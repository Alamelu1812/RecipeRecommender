package com.me.cloud;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.cloud.ByteArray;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.protobuf.ByteString;

import recipe.domain.recipe.FullRecipe;
import recipe.domain.recipe.input.Recipe;
import recipe.domain.user.Country;
import recipe.domain.user.UserDetails;
import recipe.services.bill.BillUploadService;
import recipe.services.dao.mysql.RecipeMySqlDAO;
import recipe.services.recipe.data.RecipeDataService;
import recipe.services.recipe.data.RecipeLookupService;
import recipe.services.recommender.RecipeRecommender;

@Controller
@RequestMapping(value = "/")
@MultipartConfig
public class HomeController {

	@Resource
	private RecipeMySqlDAO recipeDAO;

	@Resource
	private RecipeLookupService recipeLookupService;

	@Resource
	private BillUploadService billUploadService;

	@Resource
	private RecipeRecommender recipeRecommender;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String handleRegisterUserForm(HttpServletRequest request) {

		UserDetails user = new UserDetails();
		user.setUserName(request.getParameter("username"));
		user.setPassWord(request.getParameter("password"));
		Country country = Country.valueOf(request.getParameter("country"));
		user.setCountry(country);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = request.getParameter("dob");
		System.out.println(dateInString);
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setDateOfBirth(date);
		try {
			recipeDAO.registerUser(user);
			return "signup-success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error-page";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String handleLoginForm(HttpServletRequest request, HttpServletResponse response, ModelMap map) {

		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		HttpSession session = request.getSession();
		session.setAttribute("userId", username);
		if (recipeDAO.checkUser(username, password)) {
			return "user-dashboard";
		}
		map.addAttribute("errorMessage", "Invalid username/password!");
		return "error-page";
	}

	@RequestMapping(value = "/user/login/upload", method = RequestMethod.GET)
	public String handleUploadInventoryBill(HttpServletRequest request) {
		
		return "upload";
	}

	@RequestMapping(value = "/user/login/browse", method = RequestMethod.GET)
	public String handlebrowseInventory(HttpServletRequest request) {
		return "browse";

	}

	@RequestMapping(value = "/user/browse/id", method = RequestMethod.GET)
	public String handleSelectedInventory(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		int reciepeId = Integer.parseInt(request.getParameter("id"));
//		// find full reciepe with receipe id
//
//		// dummy code
//		FullRecipe fullRecipe = new FullRecipe();
//		Recipe r1 = new Recipe();
//		r1.setRecipeId(1);
//		r1.setRecipeName("Dosa");
//
//		fullRecipe.setRecipeMethod("ABC");
//		fullRecipe.setImageUrl("imageurl");
//
//		fullRecipe.setRecipe(r1);
//		fullRecipe.setVideoUrl("videourl");
//
//		session.setAttribute("fullRecipe", fullRecipe);
//
//		return "view-full-receipe";

		HttpSession session = request.getSession();
		int reciepeId =  Integer.parseInt(request.getParameter("id"));
//		// find full reciepe with receipe id
//		recipeLookupService.fetchRecipesForId(reciepeId);
		recipeLookupService.fetchRecipesForId(reciepeId);

		//dummy code
		recipe.domain.recipe.input.Recipe recipe = new recipe.domain.recipe.input.Recipe();
		FullRecipe fullRecipe = new FullRecipe();
		fullRecipe.setImageUrl("abc@google.com");
		fullRecipe.setVideoUrl("abc@youtube.com");

//		recipe.setRecipeId(1);
//		recipe.setRecipeName("Dosa");
//		recipe.setRating(4);
//		recipe.setCalories(1);
//		recipe.setFat(1);
//		recipe.setProtien(1);
//		recipe.setSodium(1);
//		recipe.setDesc("South Indian Dish");
//		List<String> ingredients = new ArrayList<>();
//		List<String> directions = new ArrayList<>();
//
//		ingredients.add("a");
//		ingredients.add("b");
//		ingredients.add("c");
//		ingredients.add("d");
//
//		directions.add("Step 1");
//		directions.add("Step 2");
//		directions.add("Step 3");
//		directions.add("Step 4");
//
//		recipe.setDirections(directions);
//		recipe.setIngredients(ingredients);

		session.setAttribute("recipe", recipeLookupService.fetchRecipesForId(reciepeId));
		session.setAttribute("fullRecipe", fullRecipe);

		   return "view-full-receipe";
	}

	@RequestMapping(value = "/user/login/inventory", method = RequestMethod.GET)
	public String handleFetchUserInventory(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		session.setAttribute("ingredients", recipeDAO.fetchUserInverntory(userId));
		return "inventory";
	}

	@RequestMapping(value = "/user/upload", method = RequestMethod.POST)
	public String handleImageUpload(HttpServletRequest request, ModelMap map) {
	
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;

		// Verify the content type
		String contentType = request.getContentType();

		if ((contentType.indexOf("multipart/form-data") >= 0)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// maximum size that will be stored in memory
			factory.setSizeThreshold(maxMemSize);

			// Location to save data that is larger than maxMemSize.
			factory.setRepository(new File("C:\\Users\\burmi\\eclipse-workspace\\temp\\"));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// maximum file size to be uploaded.
			upload.setSizeMax(maxFileSize);

			try {
				List<FileItem> fileItems = upload.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					billUploadService.invoke(ImmutablePair.<String, ByteString>of((String) request.getSession().getAttribute("userId"), ByteString.copyFrom(fileItem.get())));
					ByteArray byteArray = ByteArray.copyFrom(fileItem.get());
					if (byteArray.length() > 0) {
						System.out.println("Successfully uploaded image!");
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
				return "upload-failed";
			}
		}
		return "success";
	}

	@RequestMapping(value = "/user/browse", method = RequestMethod.POST)
	public String handleBrowseEvent(HttpServletRequest request, ModelMap map) {

		String userQuery = request.getParameter("query");
		HttpSession session = request.getSession();

		List<Recipe> recipies = recipeLookupService.invoke(userQuery);
		session.setAttribute("recipies", recipies);

		return "reciepe-results";

	}

	@RequestMapping(value = "/user/updateinventory", method = RequestMethod.POST)
	public String handleRemoveInventory(HttpServletRequest request, ModelMap map) {
		HttpSession session = request.getSession();
		String ingredientIds[] = request.getParameterValues("ingredientCheck");
		List<Integer> ingredientIdList = Lists.newArrayList();
		for (String ingredientId : ingredientIds) {
			ingredientIdList.add(Integer.parseInt(ingredientId));
		}
		String action =  request.getParameter("action");
		if(action.equals("REMOVE")) {
			recipeDAO.removeUserInventory((String) session.getAttribute("userId"), ingredientIdList);
		} else if(action.equals("FETCH")) {
//			List<Integer> matchedRecipeIds = recipeRecommender.invoke(ImmutablePair.<String, Set<Integer>>of((String) request.getSession().getAttribute("userId"), Sets.newHashSet(ingredientIdList)));
			//TODO: code here for fetch
			// Add content to response object
//			session.setAttribute("recipies", recipeLookupService.fetchRecipesForIds(matchedRecipeIds));

			
			
			
			
			
			recipe.domain.recipe.input.Recipe recipe = new recipe.domain.recipe.input.Recipe();
			FullRecipe fullRecipe = new FullRecipe();
			fullRecipe.setImageUrl("abc@google.com");
			fullRecipe.setVideoUrl("abc@youtube.com");


			Recipe r1 = recipeLookupService.fetchRecipesForId(333);
			Recipe r2 = recipeLookupService.fetchRecipesForId(222);
			
			session.setAttribute("recipies", Lists.newArrayList(r1, r2));
			session.setAttribute("fullRecipe", fullRecipe);

//			   return "view-full-receipe";

			
			
			
			
			
			
			return "reciepe-results";
		}
		return "inventory-removed";
	}

	@RequestMapping(value = "/user/recipe/rate", method = RequestMethod.POST)
	public String handleRateRecipe(HttpServletRequest request, ModelMap map) {

		System.out.println("Stub to rate the receipe");
		String[] idString = request.getParameterValues("rId");
		// String[] nameString = request.getParameterValues("rName");
		// System.out.println("size: " +idString.length);
		// System.out.println("size: " +nameString.length);

		int receipeId = Integer.parseInt(idString[0]);
		String rating = request.getParameter("rating");

		System.out.println("Rating is: " + rating);
		System.out.println("Id" + receipeId);

		// code to save rating in database

		return "rating-success";

	}
}