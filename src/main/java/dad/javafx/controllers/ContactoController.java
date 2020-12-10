package dad.javafx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.micv.App;
import dad.javafx.model.CV;
import dad.javafx.model.Contacto;
import dad.javafx.model.Email;
import dad.javafx.model.Telefono;
import dad.javafx.model.TipoTelefono;
import dad.javafx.model.Web;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

public class ContactoController implements Initializable{
	
    // VIEW

	@FXML
    private SplitPane contactoView;
	
    @FXML
    private TableView<Telefono> tableView_telefono;
    
    @FXML
    private TableView<Email> tableView_correo;
    
    @FXML
    private TableView<Web> tableView_web;

    @FXML
    private TableColumn<Telefono, String> tableColumnNumeroTelefono;

    @FXML
    private TableColumn<Telefono, TipoTelefono> tableColumnTipoTelefono;

    @FXML
    private Button buttonAniadir_telefono;

    @FXML
    private Button buttonEliminar_telefono;

    @FXML
    private TableColumn<Email, String> tableColumnEmail;

    @FXML
    private Button buttonAniadir_correo;

    @FXML
    private Button buttonEliminar_correo;

    @FXML
    private TableColumn<Web, String> tableColumnURL;

    @FXML
    private Button buttonAniadir_url;

    @FXML
    private Button buttonEliminar_url;
    
    public SplitPane getContactoView() {
		return contactoView;
	}
    
    // MODEL 
    
    private CV cv = new CV();
    
	public CV getCv() {
		return cv;
	}
	
	// CONTROLLER

	public ContactoController() throws IOException {
		// TODO Auto-generated constructor stub
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ContactoView.fxml"));
		loader.setController(this);
		loader.load();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cv.setContacto(new Contacto());
		
		// Bindeos
		
		tableView_telefono.itemsProperty().bindBidirectional(cv.getContacto().telefonosProperty());
		tableView_correo.itemsProperty().bindBidirectional(cv.getContacto().emailsProperty());
		tableView_web.itemsProperty().bindBidirectional(cv.getContacto().websProperty());
		
		// Tablas editables directamente
		
		tableView_telefono.setEditable(true);
		tableView_correo.setEditable(true);
		tableView_web.setEditable(true);
		
		// Formateo de columnas
		
		tableColumnNumeroTelefono.setCellValueFactory(v -> v.getValue().numeroProperty());
		tableColumnNumeroTelefono.setCellFactory(TextFieldTableCell.forTableColumn());

		tableColumnTipoTelefono.setCellValueFactory(v -> v.getValue().tipoProperty());
		tableColumnTipoTelefono.setCellFactory(ComboBoxTableCell.forTableColumn(TipoTelefono.values())); //aquí no es posible un TextFieldTableCell al ser tipo Enumerado, no es editable, es seleccionable

		tableColumnEmail.setCellValueFactory(v -> v.getValue().direccionProperty());
		tableColumnEmail.setCellFactory(TextFieldTableCell.forTableColumn()); 
		
		tableColumnURL.setCellValueFactory(v -> v.getValue().urlProperty());
		tableColumnURL.setCellFactory(TextFieldTableCell.forTableColumn());		
						
	}

	@FXML
    void onButtonAniadirTelefefonoAction(ActionEvent event) {
    	 		
		Dialog <Pair<String, TipoTelefono>> dialog = new Dialog<>();
		dialog.setTitle("Nuevo teléfono");
		dialog.setHeaderText("Introduzca el nuevo número de teléfono.");
		dialog.initOwner(App.getPrimaryStage());  //con esto logramos que en la esquina de la izquierda salga el icono de la aplicación principal
		
		VBox vbox = new VBox();
		
		HBox hboxNumeroTelefono;
		HBox hboxTipoTelefono;

		TextField textField_numeroTelefono = new TextField();
		textField_numeroTelefono.setPromptText("Número de teléfono");
		textField_numeroTelefono.setPrefWidth(155);
		
		Label numeroLabel = new Label("Número:");
		Label tipoLabel = new Label("Tipo:");
		
		ComboBox<TipoTelefono> comboBox_tipoTelefono = new ComboBox<TipoTelefono>();		
		comboBox_tipoTelefono.getItems().addAll(TipoTelefono.values());
		comboBox_tipoTelefono.setPromptText("Seleccione un tipo\t"); 
		
		Platform.runLater(() -> comboBox_tipoTelefono.requestFocus()); //aquí resaltaríamos el combo
				
		hboxNumeroTelefono = new HBox(numeroLabel, textField_numeroTelefono);
		hboxNumeroTelefono.setSpacing(5);
		hboxTipoTelefono = new HBox(tipoLabel, comboBox_tipoTelefono);
		hboxTipoTelefono.setSpacing(25);
		
		vbox.getChildren().addAll(hboxNumeroTelefono, hboxTipoTelefono);
		vbox.setSpacing(10);
		
		ButtonType buttonType_aniadir = new ButtonType("Añadir", ButtonData.OK_DONE);
		ButtonType buttonType_cancelar = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
		
		dialog.getDialogPane().setContent(vbox);
		
		dialog.getDialogPane().getButtonTypes().addAll(buttonType_aniadir, buttonType_cancelar);
				
		dialog.getDialogPane().lookupButton(buttonType_aniadir); //aquí resaltamos el botón añadir
						
		dialog.setResultConverter(dialogButton -> {
			
		    if (comboBox_tipoTelefono.getValue() == null)
		    
		    return new Pair<>("", comboBox_tipoTelefono.getItems().get(0));
		    			    	
		    	return new Pair<>(textField_numeroTelefono.getText(), comboBox_tipoTelefono.getValue());


		});
		
		Optional<Pair<String, TipoTelefono>> result = dialog.showAndWait();
		
		if(!result.get().getKey().matches("")) {
			
			Telefono telefono = new Telefono();
	    	
	    	telefono.setNumero(result.get().getKey());
	    	
	    	telefono.setTipo(result.get().getValue());
	    	
	    	cv.getContacto().getTelefonos().add(telefono);			
			
		} 
				
	}

	@FXML
    void onButtonAniadirCorreoAction(ActionEvent event) {
    	
    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("Nuevo e-mail");
    	dialog.setHeaderText("Crear una nueva de dirección de correo.");
    	dialog.setContentText("E-mail:");
    	dialog.initOwner(App.getPrimaryStage());
    	
    	dialog.getDialogPane().lookupButton(ButtonType.OK); //aquí centramos el foco en este botón 
    	dialog.getEditor().requestFocus();  //resaltamos el textField del Dialog
    	
    	Optional<String> result = dialog.showAndWait();
    	if (result.isPresent()){
    		
    		Email nuevoEmail = new Email();
    		
    		nuevoEmail.setDireccion(result.get());
    		
    		cv.getContacto().getEmails().add(nuevoEmail);
    		
    	}

    }

    @FXML
    void onButtonAniadirURLAction(ActionEvent event) {
    	
    	TextInputDialog dialog = new TextInputDialog("http://");
    	dialog.setTitle("Nueva web");
    	dialog.setHeaderText("Crear una nueva dirección web.");
    	dialog.setContentText("URL:");
    	dialog.initOwner(App.getPrimaryStage());
    	
    	dialog.getDialogPane().lookupButton(ButtonType.OK); //aquí centramos el foco en este botón 
    	dialog.getEditor().requestFocus();  //resaltamos el textField del Dialog


    	Optional<String> result = dialog.showAndWait();
    	if (result.isPresent()){
    		
    		Web nuevaWeb = new Web();
    		
    		nuevaWeb.setUrl(result.get());
    		
    		cv.getContacto().getWebs().add(nuevaWeb);
    		    		    		    	    
    	}

    }
    
    @FXML
    void onButtonEliminarTelefonoAction(ActionEvent event) {
    	
    	if(!tableView_telefono.getSelectionModel().isEmpty()) {
    		
        	Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Confirmación");
        	alert.setHeaderText("Eliminar");
        	alert.setContentText("¿Estás seguro de querer eliminar el teléfono?");
        	alert.initOwner(App.getPrimaryStage());

        	Optional<ButtonType> result = alert.showAndWait();
        	
        	if (result.get() == ButtonType.OK){
        		
        		cv.getContacto().getTelefonos().remove(tableView_telefono.getSelectionModel().getSelectedIndex()); //importante elegir index

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

	@FXML
    void OnButtonEliminarCorreoAction(ActionEvent event) {
		
		if(!tableView_correo.getSelectionModel().isEmpty()) {
			
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Confirmación");
	    	alert.setHeaderText("Eliminar");
	    	alert.setContentText("¿Estás seguro de querer eliminar el correo?");
	    	alert.initOwner(App.getPrimaryStage());

	    	Optional<ButtonType> result = alert.showAndWait();
	    	
	    	if (result.get() == ButtonType.OK){
	    		
	    		cv.getContacto().getEmails().remove(tableView_correo.getSelectionModel().getSelectedIndex());

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

    @FXML
    void onButtonEliminarURLAction(ActionEvent event) {
    	
    	if(!tableView_web.getSelectionModel().isEmpty()) {
    		
    		Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Confirmación");
        	alert.setHeaderText("Eliminar");
        	alert.setContentText("¿Estás seguro de querer eliminar la URL");
        	alert.initOwner(App.getPrimaryStage());

        	Optional<ButtonType> result = alert.showAndWait();
        	
        	if (result.get() == ButtonType.OK){
        		
        		cv.getContacto().getWebs().remove(tableView_web.getSelectionModel().getSelectedIndex());
        		
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
