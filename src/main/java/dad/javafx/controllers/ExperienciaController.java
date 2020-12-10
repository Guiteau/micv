package dad.javafx.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.micv.App;
import dad.javafx.model.CV;
import dad.javafx.model.Experiencia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

public class ExperienciaController implements Initializable {

	// VIEW

	@FXML
	private BorderPane experienciaView;

	@FXML
	private TableView<Experiencia> tableView_experiencia;

	@FXML
	private TableColumn<Experiencia, LocalDate> tableColumn_desde;

	@FXML
	private TableColumn<Experiencia, LocalDate> tableColumn_hasta;

	@FXML
	private TableColumn<Experiencia, String> tableColumn_denominacion;

	@FXML
	private TableColumn<Experiencia, String> tableColumn_empleador;

	@FXML
	private Button button_aniadir;

	@FXML
	private Button button_eliminar;

	// VIEW NUEVOEXPERIENCIAVENTANA.FXML

	@FXML
	private GridPane nuevoTituloView;

	@FXML
	private TextField textField_denominacionNuevaExperiencia;

	@FXML
	private TextField textField_empleadorNuevaExperiencia;

	@FXML
	private DatePicker datePicker_desdeNuevaExperiencia;

	@FXML
	private DatePicker datePicker_hastaNuevaExperiencia;

	@FXML
	private Button button_crearNuevaExperiencia;

	@FXML
	private Button button_cancelarNuevaExperiencia;
	
	public BorderPane getExperienciaView() {
		return experienciaView;
	}

	// MODEL

	private CV cv = new CV();
	
	public CV getCv() {
		return cv;
	}

	// CONTROLLER

	public ExperienciaController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ExperienciaView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Bindeos
		
		tableView_experiencia.itemsProperty().bindBidirectional(cv.experienciasProperty());
		tableView_experiencia.setEditable(true);
		
		// Formateo de las columnas
		
		tableColumn_desde.setCellValueFactory(v -> v.getValue().desdeProperty());
		tableColumn_desde.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter())); //Debemos parsear a String el LocalDate

		tableColumn_hasta.setCellValueFactory(v -> v.getValue().hastaProperty());
		tableColumn_hasta.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter())); 

		tableColumn_denominacion.setCellValueFactory(v -> v.getValue().denominacionProperty());
		tableColumn_denominacion.setCellFactory(TextFieldTableCell.forTableColumn());

		tableColumn_empleador.setCellValueFactory(v -> v.getValue().empleadorProperty());
		tableColumn_empleador.setCellFactory(TextFieldTableCell.forTableColumn());

	}

	@FXML
	void onButtonAniadirAction(ActionEvent event) {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/NuevaExperienciaVentana.fxml"));
			fxmlLoader.setController(this);

			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = new Stage();
			stage.setTitle("Nueva experiencia");
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/cv64x64.png")));
			stage.show();

			button_crearNuevaExperiencia.requestFocus();

			button_crearNuevaExperiencia.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					Experiencia experiencia = new Experiencia();

					experiencia.setDesde(datePicker_desdeNuevaExperiencia.getValue());
					experiencia.setHasta(datePicker_hastaNuevaExperiencia.getValue());
					experiencia.setDenominacion(textField_denominacionNuevaExperiencia.getText());
					experiencia.setEmpleador(textField_empleadorNuevaExperiencia.getText());

					cv.getExperiencias().add(experiencia);
					
					stage.close();

				}
			});

			button_cancelarNuevaExperiencia.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void onButtonEliminarAction(ActionEvent event) {
		
		if(!tableView_experiencia.getSelectionModel().isEmpty()) {
			
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Confirmación");
	    	alert.setHeaderText("Eliminar experiencia");
	    	alert.setContentText("¿Estás seguro de querer eliminar esa experiencia?");
	    	alert.initOwner(App.getPrimaryStage());

	    	Optional<ButtonType> result = alert.showAndWait();

	    	if (result.get() == ButtonType.OK){

	    		cv.getExperiencias().remove(tableView_experiencia.getSelectionModel().getSelectedIndex());
	    		    		
	    	} 
	    	
		}  else {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se ha podido eliminar");
			alert.setContentText("¡Primero debes seleccionar un registro!");
	    	alert.initOwner(App.getPrimaryStage());

			alert.showAndWait();
			
		}

	}

}
