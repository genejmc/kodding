package desarrollo2015.rest.client.controller;


import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import desaorrollo2015.rest.util.Writer;
import desarrollo2015.rest.client.domain.Person;
import desarrollo2015.rest.client.domain.PersonGsocial;
import desarrollo2015.rest.client.domain.PersonList;
import desarrollo2015.rest.client.domain.PersonGsocialList;
import desarrollo2015.rest.client.domain.Publication;
import desarrollo2015.rest.client.domain.User;

/**
 * REST service client
 */
@Controller
public class RestClientController {

	protected static Logger logger = Logger.getLogger("controller");
	private RestTemplate restTemplate = new RestTemplate();
	public String aux;
	/**
	 * Retrieves an image from the REST provider
	 * and writes the response to an output stream.
	 */
	@RequestMapping(value = "/getphoto", method = RequestMethod.GET)
	public void getPhoto(@RequestParam("id") Long id, HttpServletResponse response) {
		logger.debug("Retrieve photo with id: " + id);
		
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.IMAGE_JPEG);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<String> entity = new HttpEntity<String>(headers);	
		
		// Send the request as GET
		ResponseEntity<byte[]> result = restTemplate.exchange("http://localhost:8080/spring-rest-server/agenda/person/{id}", HttpMethod.GET, entity, byte[].class, id);
		
		// Display the image
		Writer.write(response, result.getBody());
	}
	
	/**
	 * Retrieves all records from the REST provider
	 * and displays the records in a JSP page
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public String getAll(Model model) {
		logger.debug("Retrieve all persons");
		
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<Person> entity = new HttpEntity<Person>(headers);

		// Send the request as GET
		try {
			//ResponseEntity<PersonList> result = restTemplate.exchange("http://localhost:8080/spring-rest-server/agenda/persons", HttpMethod.GET, entity, PersonList.class);
			String result = restTemplate.getForObject("http://localhost:8080/spring-rest-server/agenda/persons", String.class);
			// Add to model
			//model.addAttribute("persons", result.getBody().getData());
			//System.out.println(result.getBody().getData());
			System.out.println(result);
		} catch (Exception e) {
			logger.error(e);
			
		}
		
		// This will resolve to /WEB-INF/jsp/personspage.jsp
		return "personspage";
	}
	
	/**
	 * Retrieves a single record from the REST provider
	 * and displays the result in a JSP page
	 */
	
	@RequestMapping(value = "/getuser/{codigo}", method = RequestMethod.GET)
	public String getPersongina(@PathVariable("codigo") String codigo, Model model) {
		logger.debug("Retrieve person with id: " + codigo);
		//url="https://kodding.azurewebsites.net/Gsocial/Usuarios/Usuario/"+codigo;
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		//HttpEntity<Person> entity = new HttpEntity<Person>(headers);

		// Send the request as GET
		try {
			//ResponseEntity<Person> result = restTemplate.;
			//ResponseEntity<Person> result = restTemplate.exchange(url, HttpMethod.GET, entity, Person.class);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("codigo", codigo.toString());
			String result = restTemplate.getForObject("https://kodding.azurewebsites.net/Gsocial/Usuarios/Usuario/{codigo}", String.class, vars);
			System.out.println(result);
			//logger.debug(result);
			// Add to model
			//model.addAttribute("person", result.getBody());
			
		} catch (Exception e) {
			logger.error(e);
			
		}
		
		// This will resolve to /WEB-INF/jsp/getpage.jsp
		return "getpage";
		
	}
	@RequestMapping(value = "/getuserOI/{openid}", method = RequestMethod.GET)
	public @ResponseBody String getUserOpenId(@PathVariable("openid") String openid) {
		logger.debug("Retrieve person with id: " + openid);
		//url="https://kodding.azurewebsites.net/Gsocial/Usuarios/Usuario/"+codigo;
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		//HttpEntity<Person> entity = new HttpEntity<Person>(headers);

		// Send the request as GET
		try {
			
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("openid", openid);
			String result = restTemplate.getForObject("https://kodding.azurewebsites.net/Gsocial/Usuarios/Usuario/{openid}", String.class, vars);
			System.out.println(result);
				
			return "perfil";
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			if(e instanceof Exception){
				Exception n = (Exception) e;
				StackTraceElement stackTrace = n.getStackTrace()[0];
				System.out.println("Unexpected Exception due at " + stackTrace.getLineNumber());
				
				// Create Desktop object
				 Desktop d=Desktop.getDesktop();

							
			}
			return null;
		}
		
		// This will resolve to /WEB-INF/jsp/getpage.jsp
		
		
	}
	
	@RequestMapping(value = "/getpublications/{codigo}", method = RequestMethod.GET)
	public String getPubPerson(@PathVariable("codigo") String codigo, Model model) {
		logger.debug("Retrieve person with id: " + codigo);
		//url="https://kodding.azurewebsites.net/Gsocial/Usuarios/Usuario/"+codigo;
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		//HttpEntity<Person> entity = new HttpEntity<Person>(headers);

		// Send the request as GET
		try {
			//ResponseEntity<Person> result = restTemplate.;
			//ResponseEntity<Person> result = restTemplate.exchange(url, HttpMethod.GET, entity, Person.class);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("codigo", codigo.toString());
			String result = restTemplate.getForObject("https://kodding.azurewebsites.net/Gsocial/Publicaciones/Administrador/{codigo}", String.class, vars);
			System.out.println(result);
			//logger.debug(result);
			// Add to model
			//model.addAttribute("person", result.getBody());
			
		} catch (Exception e) {
			logger.error(e);
			
		}
		
		// This will resolve to /WEB-INF/jsp/getpage.jsp
		return "getpage";
		
	}
	
	@RequestMapping(value = "/getfriends/{codigo}", method = RequestMethod.GET)
	public String getFriends(@PathVariable("codigo") String codigo, Model model) {
		logger.debug("Retrieve person with id: " + codigo);
		//url="https://kodding.azurewebsites.net/Gsocial/Usuarios/Usuario/"+codigo;
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		//HttpEntity<Person> entity = new HttpEntity<Person>(headers);

		// Send the request as GET
		try {
			//ResponseEntity<Person> result = restTemplate.;
			//ResponseEntity<Person> result = restTemplate.exchange(url, HttpMethod.GET, entity, Person.class);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("codigo", codigo.toString());
			String result = restTemplate.getForObject("https://kodding.azurewebsites.net/Gsocial/Contactos/{codigo}", String.class, vars);
			System.out.println(result);
			//logger.debug(result);
			// Add to model
			//model.addAttribute("person", result.getBody());
			
		} catch (Exception e) {
			logger.error(e);
			
		}
		
		// This will resolve to /WEB-INF/jsp/getpage.jsp
		return "getpage";
		
	}
	
	@RequestMapping(value = "/addPu", method = RequestMethod.GET)
	public String getaddPublication(Model model) {
		logger.debug("Received request to show add publication");

		// Create new Person and add to model
		// This is the formBackingOBject
		model.addAttribute("personAttribute", new Publication("1234","2015-06-04 8:33:25","1","imagen","Prueba Publicacion","participante"));

		// This will resolve to /WEB-INF/jsp/addpage.jsp
		return "addpage";
	}
	
	@RequestMapping(value = "/adduserio", method = RequestMethod.POST)
	public String addUserbyOpenID(User user,
			 Model model) {
		logger.debug("Add new User by open id");
		
		
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		// Pass the new person and header
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);

		// Send the request as POST
		try {
			ResponseEntity<User> result = restTemplate.exchange("https://kodding.azurewebsites.net/Gsocial/Usuarios/Post/", HttpMethod.POST, entity, User.class);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// This will resolve to /WEB-INF/jsp/resultpage.jsp
		return "resultpage";
	}
	
	@RequestMapping(value = "/addP", method = RequestMethod.POST)
	public String addPublication(@ModelAttribute("personAttribute") Publication publication,
						 Model model) {
		logger.debug("Add new publication");
		
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		// Pass the new person and header
		HttpEntity<Publication> entity = new HttpEntity<Publication>(publication, headers);

		// Send the request as POST
		try {
			ResponseEntity<Publication> result = restTemplate.exchange("https://kodding.azurewebsites.net/Gsocial/Publicaciones/Post/1", HttpMethod.POST, entity, Publication.class);
		} catch (Exception e) {
			logger.error(e);
		}
		
		// This will resolve to /WEB-INF/jsp/resultpage.jsp
		return "resultpage";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddPage(Model model) {
		logger.debug("Received request to show add page");

		// Create new Person and add to model
		// This is the formBackingOBject
		model.addAttribute("personAttribute", new Person());

		// This will resolve to /WEB-INF/jsp/addpage.jsp
		return "addpage";
	}
	/**
	 * Sends a new record to the REST provider
	 * based on the information submitted from the JSP add page.
	 */
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("personAttribute") Person person,
						 Model model) {
		logger.debug("Add new person");
		
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		// Pass the new person and header
		HttpEntity<Person> entity = new HttpEntity<Person>(person, headers);
		
		// Send the request as POST
		try {
			ResponseEntity<Person> result = restTemplate.exchange("http://localhost:8080/spring-rest-server/agenda/person", HttpMethod.POST, entity, Person.class);
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		// This will resolve to /WEB-INF/jsp/resultpage.jsp
		return "resultpage";
	}
	
	/**
	 * Sends a new record to the REST provider
	 * based on the information submitted from the JSP add page.
	 */
	@RequestMapping(value = "/postpublication/{codigo}", method = RequestMethod.POST)
	public String postPublication(@PathVariable("codigo") String codigo, Model model) {
		logger.debug("Retrieve person with id: " + codigo);
		//url="https://kodding.azurewebsites.net/Gsocial/Usuarios/Usuario/"+codigo;
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		//HttpEntity<Person> entity = new HttpEntity<Person>(headers);

		// Send the request as POST
		try {
			//ResponseEntity<Person> result = restTemplate.;
			//ResponseEntity<Person> result = restTemplate.exchange(url, HttpMethod.GET, entity, Person.class);
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("codigo", codigo.toString());
			String result = restTemplate.getForObject("https://kodding.azurewebsites.net/Gsocial/Contactos/{codigo}", String.class, vars);
			System.out.println(result);
			//logger.debug(result);
			// Add to model
			//model.addAttribute("person", result.getBody());
			
		} catch (Exception e) {
			logger.error(e);
			
		}
		
		// This will resolve to /WEB-INF/jsp/getpage.jsp
		return "resultpage";
		
	}
	
	/**
     * Retrieves the JSP update page
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String getUpdatePage(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	// Retrieve existing Person and add to model
    	// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<Person> entity = new HttpEntity<Person>(headers);

		// Send the request as GET
		try {
			ResponseEntity<Person> result = restTemplate.exchange("http://localhost:8080/spring-rest-server/agenda/person/{id}", HttpMethod.GET, entity, Person.class, id);
			// Add to model
			model.addAttribute("personAttribute", result.getBody());
			
		} catch (Exception e) {
			logger.error(e);
		}
    	
    	// This will resolve to /WEB-INF/jsp/updatepage.jsp
    	return "updatepage";
	}
	
	/**
	 * Sends an update request to the REST provider
	 * based on the information submitted from the JSP update page.
	 */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute("personAttribute") Person person,
						@RequestParam(value="id",  required=true) Long id,
						Model model) {
		logger.debug("Update existing person");
		
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		// Pass the new person and header
		HttpEntity<Person> entity = new HttpEntity<Person>(person, headers);
		
		// Send the request as PUT
		ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/spring-rest-server/agenda/person/{id}", HttpMethod.PUT, entity, String.class, id);

		// This will resolve to /WEB-INF/jsp/resultpage.jsp
		return "resultpage";
    }
    
    /**
	 * Sends a delete request to the REST provider
	 */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deletePerson(@RequestParam("id") Long id,
										Model model) {
    	logger.debug("Delete existing person");
    	
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		
		// Prepare header
    	HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<String> entity = new HttpEntity<String>(headers);	
		
		// Send the request as DELETE
		ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/spring-rest-server/agenda/person/{id}", HttpMethod.DELETE, entity, String.class, id);
		
		// This will resolve to /WEB-INF/jsp/resultpage.jsp
		return "resultpage";
    }
}
