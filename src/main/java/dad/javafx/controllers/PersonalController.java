package dad.javafx.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.model.CV;
import dad.javafx.model.Nacionalidad;
import dad.javafx.model.Personal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonalController implements Initializable {

	// VIEW

	@FXML
	private GridPane personalView;

	@FXML
	private TextField textField_dniNiePasaporte;

	@FXML
	private TextField textField_nombre;

	@FXML
	private TextField textField_apellidos;

	@FXML
	private DatePicker datePicker_fechaNacimiento;

	@FXML
	private TextArea textArea_direccion;

	@FXML
	private TextField textField_codPostal;

	@FXML
	private TextField textField_localidad;

	@FXML
	private ComboBox<String> comboBox_pais;

	@FXML
	private Button button_quitar;

	@FXML
	private Button button_aniadir;

	@FXML
	private ListView<Nacionalidad> listView_nacionalidad;
	
	public GridPane getPersonalView() {
		return personalView;
	}

	// MODEL

	private CV cv = new CV();

	public CV getCv() {
		return cv;
	}

	private ObservableList<String> observablelistNacionalidades = FXCollections.observableArrayList();
	private ObservableList<String> observablelistPaises = FXCollections.observableArrayList();

	public void rellenarListaPaises() {

		try {

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/csv/paises.csv"));

			String line;

			while ((line = br.readLine()) != null) {

				observablelistPaises.add(line);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void rellenarListaNacionalidades() {

		try {

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/csv/nacionalidades.csv"));

			String line;

			while ((line = br.readLine()) != null) {

				observablelistNacionalidades.add(line);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// CONTROLLER

	public PersonalController() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PersonalView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		this.rellenarListaNacionalidades();
		this.rellenarListaPaises();

		// cargamos el combo con los países

		comboBox_pais.getItems().addAll(observablelistPaises);

		// asignamos un nuevo objeto Personal a CV

		cv.setPersonal(new Personal());

		// BINDEOS

		cv.getPersonal().identificacionProperty().bindBidirectional(textField_dniNiePasaporte.textProperty());
		cv.getPersonal().nombreProperty().bindBidirectional(textField_nombre.textProperty());
		cv.getPersonal().apellidosProperty().bindBidirectional(textField_apellidos.textProperty());
		cv.getPersonal().fechaNacimientoProperty().bindBidirectional(datePicker_fechaNacimiento.valueProperty());
		cv.getPersonal().direccionProperty().bindBidirectional(textArea_direccion.textProperty());
		cv.getPersonal().codigoPostalProperty().bindBidirectional(textField_codPostal.textProperty());
		cv.getPersonal().localidadProperty().bindBidirectional(textField_localidad.textProperty());
		cv.getPersonal().paisProperty().bindBidirectional(comboBox_pais.valueProperty());
		cv.getPersonal().nacionalidadesProperty().bindBidirectional(listView_nacionalidad.itemsProperty());

	}

	@FXML
	void onAniadirButtonAction(ActionEvent event) {

		boolean nacionalidadAniadida = false;
		Nacionalidad nacionalidadElegida = new Nacionalidad(); // nos tenemos que crear el objeto nacionalidad para
																// setear su atributo denominación con el String del
																// combo

		ChoiceDialog<String> dialog = new ChoiceDialog<>(observablelistNacionalidades.get(0),
				observablelistNacionalidades);
		dialog.setTitle("Nueva Nacionalidad");
		dialog.setHeaderText("Añadir una nacionalidad");
		dialog.setContentText("Seleccione una nacionalidad");

		Optional<String> result = dialog.showAndWait();

		if (result.isPresent()) {

			for (int i = 0; i < cv.getPersonal().getNacionalidades().size(); i++) {

				if (cv.getPersonal().getNacionalidades().get(i).getDenominacion().matches(result.get())) // comprobamos
																											// si ya se
																											// ha
																											// añadido
																											// previamente
																											// la
																											// nacionalidad

					nacionalidadAniadida = true;

			}

			if (!nacionalidadAniadida) {

				nacionalidadElegida.setDenominacion(result.get());

				cv.getPersonal().getNacionalidades().add(nacionalidadElegida); // metemos un nuevo
																				// objeto
																				// nacionalidad
																				// al ListProperty
			}

		}

	}

	@FXML
	void onQuitarButtonAction(ActionEvent event) {

		cv.getPersonal().getNacionalidades().remove(listView_nacionalidad.getSelectionModel().getSelectedItem());

	}

}
