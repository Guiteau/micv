package dad.javafx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.micv.App;
import dad.javafx.model.CV;
import dad.javafx.model.Conocimiento;
import dad.javafx.model.Idioma;
import dad.javafx.model.Nivel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConocimientosController implements Initializable {

	// VIEW

	@FXML
	private BorderPane conocimientosView;

	@FXML
	private TableView<Conocimiento> tableView_conocimientos;

	@FXML
	private TableColumn<Conocimiento, String> tableColumn_denominacion;

	@FXML
	private TableColumn<Conocimiento, Nivel> tableColumn_nivel;

	@FXML
	private Button button_aniadirConocimiento;

	@FXML
	private Button button_aniadirIdioma;

	@FXML
	private Button button_eliminar;

	// VIEW NUEVOCONOCIMIENTOVENTANA.FXML

	@FXML
	private VBox nuevoConocimientoView;

	@FXML
	private TextField textField_denominacionNuevoConocimiento;

	@FXML
	private ComboBox<Nivel> comboBox_nivelNuevoConocimiento;

	@FXML
	private Button button_reiniciarComboNivel_nuevoConocimiento;

	@FXML
	private Button button_crearNuevoConocimiento;

	@FXML
	private Button button_cancelarNuevoConocimiento;

	// VIEW NUEVOIDIOMAVENTANA.FXML

	@FXML
	private VBox nuevoIdiomaView;

	@FXML
	private TextField textField_denominacionNuevoIdioma;

	@FXML
	private ComboBox<Nivel> comboBox_nivelNuevoIdioma;

	@FXML
	private Button button_reiniciarComboNuevoIdioma;

	@FXML
	private TextField textField_certificacionNuevoIdioma;

	@FXML
	private Button button_crearNuevoIdioma;

	@FXML
	private Button button_cancelarNuevoIdioma;
	
	public BorderPane getConocimientosView() {
		return conocimientosView;
	}

	// MODEL

	private CV cv = new CV();
	
	public CV getCv() {
		return cv;
	}

	// CONTROLLER


	public ConocimientosController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConocimientosView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Bindeos
		
		tableView_conocimientos.itemsProperty().bindBidirectional(cv.conocimientosProperty());
		tableView_conocimientos.setEditable(true);

		// Formateo de las columnas

		tableColumn_denominacion.setCellValueFactory(v -> v.getValue().denominacionProperty());
		tableColumn_denominacion.setCellFactory(TextFieldTableCell.forTableColumn());

		tableColumn_nivel.setCellValueFactory(v -> v.getValue().nivelProperty());
		tableColumn_nivel.setCellFactory(ComboBoxTableCell.forTableColumn(Nivel.values()));

	}


	@FXML
	void onButtonAniadirConocimientoAction(ActionEvent event) {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/NuevoConocimientoVentana.fxml"));
			fxmlLoader.setController(this);

			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = new Stage();
			stage.setTitle("Nuevo conocimiento");
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/cv64x64.png")));
			stage.show();

			comboBox_nivelNuevoConocimiento.getItems().setAll(Nivel.values());

			button_crearNuevoConocimiento.requestFocus();

			button_crearNuevoConocimiento.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					Conocimiento conocimiento = new Conocimiento();
					
					if(!textField_denominacionNuevoConocimiento.getText().matches("") | !comboBox_nivelNuevoConocimiento.getSelectionModel().isEmpty()) {
						
						conocimiento.setDenominacion(textField_denominacionNuevoConocimiento.textProperty().get());
						conocimiento.setNivel(comboBox_nivelNuevoConocimiento.valueProperty().getValue());

						cv.getConocimientos().add(conocimiento);
						
					}

					stage.close();

				}
			});

			button_cancelarNuevoConocimiento.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

			button_reiniciarComboNivel_nuevoConocimiento.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) { // reiniciamos el combo de nivel a null (reset)

					comboBox_nivelNuevoConocimiento.setValue(null);

				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void onButtonAniadirIdiomaAction(ActionEvent event) {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/NuevoConocimiento_Idioma_Ventana.fxml"));
			fxmlLoader.setController(this);

			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = new Stage();
			stage.setTitle("Nuevo idioma");
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/cv64x64.png")));
			stage.show();

			comboBox_nivelNuevoIdioma.getItems().setAll(Nivel.values());

			button_crearNuevoIdioma.requestFocus();

			button_crearNuevoIdioma.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					Conocimiento conocimiento = new Conocimiento();
					
					Idioma idioma = new Idioma();
					
					if(!textField_denominacionNuevoIdioma.getText().matches("") | !comboBox_nivelNuevoIdioma.getSelectionModel().isEmpty()
							| !textField_certificacionNuevoIdioma.getText().matches("")) {
						
						conocimiento.setDenominacion(textField_denominacionNuevoIdioma.getText());
						conocimiento.setNivel(comboBox_nivelNuevoIdioma.getSelectionModel().getSelectedItem());
						idioma.setCertificacion(textField_certificacionNuevoIdioma.getText());

						conocimiento.setIdioma(idioma);
						
						cv.getConocimientos().add(conocimiento);
						
					}


					stage.close();

				}
			});

			button_cancelarNuevoIdioma.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

			button_reiniciarComboNuevoIdioma.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					comboBox_nivelNuevoIdioma.valueProperty().setValue(null); // reiniciamos el combo de nivel dejándolo a nulo

				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void onButtonEliminarAction(ActionEvent event) {
		
		if(!tableView_conocimientos.getSelectionModel().isEmpty()) {
			
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Confirmación");
	    	alert.setHeaderText("Eliminación de registro");
	    	alert.setContentText("¿Estás seguro de querer eliminar el registro?");
	    	alert.initOwner(App.getPrimaryStage());

	    	Optional<ButtonType> result = alert.showAndWait();
	    	
	    	if (result.get() == ButtonType.OK){

	    		cv.getConocimientos().remove(tableView_conocimientos.getSelectionModel().getSelectedIndex());
	    		    		
	    	} 
			
		} else {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se ha podido eliminar");
			alert.setContentText("¡Primero debes seleccionar un registro!");
	    	alert.initOwner(App.getPrimaryStage());

			alert.showAndWait();
			
		}

	}

}
