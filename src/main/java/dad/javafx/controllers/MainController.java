package dad.javafx.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.App;
import dad.javafx.model.CV;
import dad.javafx.utils.JSONUtils;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController implements Initializable {
	
	// VIEW

	@FXML
	private BorderPane mainView;

	@FXML
	private ImageView ImageNuevo, ImageAbrir, ImageGuardar;

	@FXML
	private Tab tab_personal, tab_contacto, tab_formacion, tab_experiencia, tab_conocimientos;
	
	public BorderPane getMainView() {
		return mainView;
	}		

	// MODEL

	private	PersonalController personalController = new PersonalController();
	private	ContactoController contactoController = new ContactoController();
	private	FormacionController formacionController = new FormacionController();
	private	ExperienciaController experienciaController = new ExperienciaController();
	private	ConocimientosController conocimientoController = new ConocimientosController();
	
	CV cv = new CV();
	
	public CV getCv() {
		return cv;
	}

	private File archivoGuardado;
	
	public MainController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

			// Bindeos con los controladores
			
			cv.personalProperty().bindBidirectional(personalController.getCv().personalProperty());
			cv.contactoProperty().bindBidirectional(contactoController.getCv().contactoProperty());
			cv.titulosProperty().bindBidirectional(formacionController.getCv().titulosProperty());
			cv.experienciasProperty().bindBidirectional(experienciaController.getCv().experienciasProperty());
			cv.conocimientosProperty().bindBidirectional(conocimientoController.getCv().conocimientosProperty());
			
			// Asignación de las vistas a las pestañas
			
			tab_personal.setContent(personalController.getPersonalView());
			tab_contacto.setContent(contactoController.getContactoView());
			tab_formacion.setContent(formacionController.getFormacionView());
			tab_experiencia.setContent(experienciaController.getExperienciaView());
			tab_conocimientos.setContent(conocimientoController.getConocimientosView());

	}


	@FXML
	void OnNuevoAction(ActionEvent event) {
		
		archivoGuardado = null;
		
		// Personal model
		
		cv.getPersonal().setIdentificacion(new String());
		cv.getPersonal().setNombre(new String());
		cv.getPersonal().setApellidos(new String());
		cv.getPersonal().setFechaNacimiento(null);
		cv.getPersonal().setDireccion(new String());
		cv.getPersonal().setCodigoPostal(new String());
		cv.getPersonal().setLocalidad(new String());
		cv.getPersonal().setPais(null);
		cv.getPersonal().setNacionalidades(FXCollections.observableArrayList());
		
		// Contacto model
		
		cv.getContacto().setTelefonos(FXCollections.observableArrayList());
		cv.getContacto().setEmails(FXCollections.observableArrayList());
		cv.getContacto().setWebs(FXCollections.observableArrayList());
		
		// Formación model
		
		cv.setTitulos(FXCollections.observableArrayList());
		
		// Experiencias model
		
		cv.setExperiencias(FXCollections.observableArrayList());
		
		// Conocimientos model
		
		cv.setConocimientos(FXCollections.observableArrayList());

	}

	@FXML
	void onAbrirAction(ActionEvent event) {
		
		CV cvAbierto = null;
		
		try {

			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Abrir un currículum");
			fileChooser.getExtensionFilters().add(new ExtensionFilter("Currículum Vitae (*.cv)", ".cv"));
			fileChooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos", "*.*"));
			archivoGuardado = fileChooser.showOpenDialog(App.getPrimaryStage());
			
			if (archivoGuardado != null) {

				cvAbierto = JSONUtils.fromJson(archivoGuardado, CV.class);
				
			}} catch (Exception e) {
				e.printStackTrace();
			}
		
			//Asignamos al objeto CV principal la información recogida por el objeto auxiliar
		
			// Personal model
		
			cv.getPersonal().setIdentificacion(cvAbierto.getPersonal().getIdentificacion());
			cv.getPersonal().setNombre(cvAbierto.getPersonal().getNombre());
			cv.getPersonal().setApellidos(cvAbierto.getPersonal().getApellidos());
			cv.getPersonal().setFechaNacimiento(cvAbierto.getPersonal().getFechaNacimiento());
			cv.getPersonal().setDireccion(cvAbierto.getPersonal().getDireccion());
			cv.getPersonal().setCodigoPostal(cvAbierto.getPersonal().getCodigoPostal());
			cv.getPersonal().setLocalidad(cvAbierto.getPersonal().getLocalidad());
			cv.getPersonal().setPais(cvAbierto.getPersonal().getPais());
			cv.getPersonal().setNacionalidades(cvAbierto.getPersonal().getNacionalidades());
		
			// Contacto model
			
			cv.getContacto().setTelefonos(cvAbierto.getContacto().getTelefonos());
			cv.getContacto().setEmails(cvAbierto.getContacto().getEmails());
			cv.getContacto().setWebs(cvAbierto.getContacto().getWebs());
		
			// Formación model
			
			cv.setTitulos(cvAbierto.getTitulos());
		
			// Experiencias model
			
			cv.setExperiencias(cvAbierto.getExperiencias());
		
			// Conocimientos model
			
			cv.setConocimientos(cvAbierto.getConocimientos());

		}


	@FXML
	void onGuardarAction(ActionEvent event) {
		
		if(archivoGuardado != null) {
						
			try {
				
				JSONUtils.toJson(archivoGuardado, this.getCv());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			
			this.onGuardarComoAction(event);  // redirigimos la acción al evento de Guardar Como
			
		}
	
	}

	@FXML
	void onGuardarComoAction(ActionEvent event) {
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Guardar un currículum");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Currículum Vitae (*.cv)", ".cv"));
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos", "*.*"));
		archivoGuardado = fileChooser.showOpenDialog(App.getPrimaryStage());  //aquí evitamos que podamos pasar de la ventana del programa a la de guardar, la bloquea
		
		if (archivoGuardado != null) {

			try {

				JSONUtils.toJson(archivoGuardado, this.getCv());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@FXML
	void onSalirAction(ActionEvent event) {
		
		App.getPrimaryStage().close();

	}

	@FXML
	void onAcercaDeAction(ActionEvent event) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Acerca de MiCV");
		alert.setHeaderText("Desarrollado con JavaFX");
		alert.setContentText("Programa para creación y edición de currículums");
		alert.initOwner(App.getPrimaryStage());

		alert.showAndWait();

	}

}
