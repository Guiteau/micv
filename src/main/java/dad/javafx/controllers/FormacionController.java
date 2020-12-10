package dad.javafx.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.micv.App;
import dad.javafx.model.CV;
import dad.javafx.model.Titulo;
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

public class FormacionController implements Initializable{
	
    // VIEW

	@FXML
    private BorderPane formacionView;

    @FXML
    private TableView<Titulo> tableViewFormacion;

    @FXML
    private TableColumn<Titulo, LocalDate> tableColumn_desde;

    @FXML
    private TableColumn<Titulo, LocalDate> tableColumn_hasta;

    @FXML
    private TableColumn<Titulo, String> tableColumn_denominacion;

    @FXML
    private TableColumn<Titulo, String> tableColumn_organizador;

    @FXML
    private Button button_aniadir;

    @FXML
    private Button button_eliminar;
    
    @FXML
    private GridPane nuevoTituloView;
    
    // VIEW NUEVOTITULOVENTANA.FXML

    @FXML
    private TextField textField_denominacionNuevoTitulo;

    @FXML
    private TextField textField_organizadorNuevoTitulo;

    @FXML
    private DatePicker datePicker_desdeNuevoTitulo;

    @FXML
    private DatePicker datePicker_hastaNuevoTitulo;

    @FXML
    private Button button_crearNuevoTitulo;

    @FXML
    private Button button_cancelarNuevoTitulo;
    
    public BorderPane getFormacionView() {
		return formacionView;
	}	
	
	// MODEL
	
	private CV cv = new CV();
	
	public CV getCv() {
		return cv;
	}
	
	// CONTROLLER

	public FormacionController() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FormacionView.fxml"));
		loader.setController(this);
		loader.load();
	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Bindeos
		
		tableViewFormacion.itemsProperty().bindBidirectional(cv.titulosProperty());
		tableViewFormacion.setEditable(true);
				
		//setCellValueFactory indica cómo rellenar (con qué dato) cada una de las celdas de la tabla y nos retonará una instancia de TableColumn
		//setCellFactory es responsable de devolver los datos contenidos en cada celda de una sola columna (TableColumn)
		//TextFieldTableCell.forTableColumn() nos permitirá editar cada celda directamente
		
		// Formateo de columnas
		
		tableColumn_desde.setCellValueFactory(v -> v.getValue().desdeProperty());
		tableColumn_desde.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter())); //debe parsearse a tipo String el LocalDate
		
		tableColumn_hasta.setCellValueFactory(v -> v.getValue().hastaProperty());
		tableColumn_hasta.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
		
		tableColumn_denominacion.setCellValueFactory(v -> v.getValue().denominacionProperty());
		tableColumn_denominacion.setCellFactory(TextFieldTableCell.forTableColumn());

		tableColumn_organizador.setCellValueFactory(v -> v.getValue().organizadorProperty());
		tableColumn_organizador.setCellFactory(TextFieldTableCell.forTableColumn());
							
		
						
	}

	@FXML
    void onButtonAniadirAction(ActionEvent event) {
		
		try {
    	
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/fxml/NuevoTituloVentana.fxml"));
		fxmlLoader.setController(this);

		Scene scene = new Scene(fxmlLoader.load());
		
			Stage stage = new Stage();
			stage.setTitle("Nuevo título");
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/cv64x64.png")));
			stage.show();
			
			button_crearNuevoTitulo.requestFocus();
			
			button_crearNuevoTitulo.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					
		    		Titulo titulo = new Titulo();

		    		titulo.setDesde(datePicker_desdeNuevoTitulo.valueProperty().getValue());
		    		titulo.setHasta(datePicker_hastaNuevoTitulo.valueProperty().getValue());
		    		titulo.setDenominacion(textField_denominacionNuevoTitulo.textProperty().get());
		    		titulo.setOrganizador(textField_organizadorNuevoTitulo.textProperty().get());
		    		
		    		cv.getTitulos().add(titulo);
		    							
					stage.close();

				}
			});
			
			button_cancelarNuevoTitulo.setOnAction(new EventHandler<ActionEvent>() {

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
    	
    	if(!tableViewFormacion.getSelectionModel().isEmpty()) {
    		
        	Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Confirmación");
        	alert.setHeaderText("Eliminar titulación");
        	alert.setContentText("¿Estás seguro de querer eliminar esa formación?");
        	alert.initOwner(App.getPrimaryStage());

        	Optional<ButtonType> result = alert.showAndWait();
        	
        	if (result.get() == ButtonType.OK){
        		
        		cv.getTitulos().remove(tableViewFormacion.getSelectionModel().getSelectedIndex());
        		
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
