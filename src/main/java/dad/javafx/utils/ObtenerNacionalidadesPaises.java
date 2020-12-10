package dad.javafx.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObtenerNacionalidadesPaises {

	private ObservableList<String> nacionalidadesParaCombo = FXCollections.observableArrayList();
	private ObservableList<String> paisesParaCombo = FXCollections.observableArrayList();
	private String dato;
	private int cont;
	private String nacionalidad;
	private String pais;


	public ObtenerNacionalidadesPaises() {

		/**
		 * obtained from
		 * https://gist.github.com/edgardo001/767169452b99e021250769ae12a1aaf1#file-nacionalidad-sql
		 */

		dato = "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Afganistán','AFGANA','AFG');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Albania','ALBANESA','ALB');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Alemania','ALEMANA','DEU');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Andorra','ANDORRANA','AND');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Angola','ANGOLEÑA','AGO');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('AntiguayBarbuda','ANTIGUANA','ATG');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('ArabiaSaudita','SAUDÍ','SAU');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Argelia','ARGELINA','DZA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Argentina','ARGENTINA','ARG');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Armenia','ARMENIA','ARM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Aruba','ARUBEÑA','ABW');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Australia','AUSTRALIANA','AUS');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Austria','AUSTRIACA','AUT');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Azerbaiyán','AZERBAIYANA','AZE');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Bahamas','BAHAMEÑA','BHS');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Bangladés','BANGLADESÍ','BGD');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Barbados','BARBADENSE','BRB');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Baréin','BAREINÍ','BHR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Bélgica','BELGA','BEL');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Belice','BELICEÑA','BLZ');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Benín','BENINÉSA','BEN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Bielorrusia','BIELORRUSA','BLR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Birmania','BIRMANA','MMR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Bolivia','BOLIVIANA','BOL');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('BosniayHerzegovina','BOSNIA','BIH');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Botsuana','BOTSUANA','BWA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Brasil','BRASILEÑA','BRA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Brunéi','BRUNEANA','BRN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Bulgaria','BÚLGARA','BGR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('BurkinaFaso','BURKINÉS','BFA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Burundi','BURUNDÉSA','BDI');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Bután','BUTANÉSA','BTN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('CaboVerde','CABOVERDIANA','CPV');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Camboya','CAMBOYANA','KHM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Camerún','CAMERUNESA','CMR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Canadá','CANADIENSE','CAN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Catar','CATARÍ','QAT');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Chad','CHADIANA','TCD');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Chile','CHILENA','CHL');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('China','CHINA','CHN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Chipre','CHIPRIOTA','CYP');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('CiudaddelVaticano','VATICANA','VAT');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Colombia','COLOMBIANA','COL');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Comoras','COMORENSE','COM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('CoreadelNorte','NORCOREANA','PRK');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('CoreadelSur','SURCOREANA','KOR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('CostadeMarfil','MARFILEÑA','CIV');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('CostaRica','COSTARRICENSE','CRI');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Croacia','CROATA','HRV');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Cuba','CUBANA','CUB');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Dinamarca','DANÉSA','DNK');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Dominica','DOMINIQUÉS','DMA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Ecuador','ECUATORIANA','ECU');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Egipto','EGIPCIA','EGY');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('ElSalvador','SALVADOREÑA','SLV');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('EmiratosÁrabesUnidos','EMIRATÍ','ARE');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Eritrea','ERITREA','ERI');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Eslovaquia','ESLOVACA','SVK');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Eslovenia','ESLOVENA','SVN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('España','ESPAÑOLA','ESP');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('EstadosUnidos','ESTADOUNIDENSE','USA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Estonia','ESTONIA','EST');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Etiopía','ETÍOPE','ETH');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Filipinas','FILIPINA','PHL');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Finlandia','FINLANDÉSA','FIN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Fiyi','FIYIANA','FJI');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Francia','FRANCÉSA','FRA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Gabón','GABONÉSA','GAB');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Gambia','GAMBIANA','GMB');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Georgia','GEORGIANA','GEO');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Gibraltar','GIBRALTAREÑA','GIB');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Ghana','GHANÉSA','GHA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Granada','GRANADINA','GRD');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Grecia','GRIEGA','GRC');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Groenlandia','GROENLANDÉSA','GRL');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Guatemala','GUATEMALTECA','GTM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Guineaecuatorial','ECUATOGUINEANA','GNQ');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Guinea','GUINEANA','GIN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Guinea-Bisáu','GUINEANA','GNB');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Guyana','GUYANESA','GUY');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Haití','HAITIANA','HTI');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Honduras','HONDUREÑA','HND');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Hungría','HÚNGARA','HUN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('India','HINDÚ','IND');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Indonesia','INDONESIA','IDN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Irak','IRAQUÍ','IRQ');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Irán','IRANÍ','IRN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Irlanda','IRLANDÉSA','IRL');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Islandia','ISLANDÉSA','ISL');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('IslasCook','COOKIANA','COK');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('IslasMarshall','MARSHALÉSA','MHL');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('IslasSalomón','SALOMONENSE','SLB');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Israel','ISRAELÍ','ISR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Italia','ITALIANA','ITA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Jamaica','JAMAIQUINA','JAM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Japón','JAPONÉSA','JPN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Jordania','JORDANA','JOR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Kazajistán','KAZAJA','KAZ');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Kenia','KENIATA','KEN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Kirguistán','KIRGUISA','KGZ');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Kiribati','KIRIBATIANA','KIR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Kuwait','KUWAITÍ','KWT');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Laos','LAOSIANA','LAO');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Lesoto','LESOTENSE','LSO');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Letonia','LETÓNA','LVA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Líbano','LIBANÉSA','LBN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Liberia','LIBERIANA','LBR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Libia','LIBIA','LBY');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Liechtenstein','LIECHTENSTEINIANA','LIE');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Lituania','LITUANA','LTU');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Luxemburgo','LUXEMBURGUÉSA','LUX');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Madagascar','MALGACHE','MDG');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Malasia','MALASIA','MYS');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Malaui','MALAUÍ','MWI');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Maldivas','MALDIVA','MDV');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Malí','MALIENSE','MLI');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Malta','MALTÉSA','MLT');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Marruecos','MARROQUÍ','MAR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Martinica','MARTINIQUÉS','MTQ');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Mauricio','MAURICIANA','MUS');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Mauritania','MAURITANA','MRT');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('México','MEXICANA','MEX');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Micronesia','MICRONESIA','FSM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Moldavia','MOLDAVA','MDA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Mónaco','MONEGASCA','MCO');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Mongolia','MONGOLA','MNG');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Montenegro','MONTENEGRINA','MNE');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Mozambique','MOZAMBIQUEÑA','MOZ');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Namibia','NAMIBIA','NAM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Nauru','NAURUANA','NRU');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Nepal','NEPALÍ','NPL');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Nicaragua','NICARAGÜENSE','NIC');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Níger','NIGERINA','NER');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Nigeria','NIGERIANA','NGA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Noruega','NORUEGA','NOR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('NuevaZelanda','NEOZELANDÉSA','NZL');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Omán','OMANÍ','OMN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('PaísesBajos','NEERLANDÉSA','NLD');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Pakistán','PAKISTANÍ','PAK');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Palaos','PALAUANA','PLW');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Palestina','PALESTINA','PSE');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Panamá','PANAMEÑA','PAN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('PapúaNuevaGuinea','PAPÚ','PNG');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Paraguay','PARAGUAYA','PRY');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Perú','PERUANA','PER');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Polonia','POLACA','POL');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Portugal','PORTUGUÉSA','PRT');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('PuertoRico','PUERTORRIQUEÑA','PRI');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('ReinoUnido','BRITÁNICA','GBR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('RepúblicaCentroafricana','CENTROAFRICANA','CAF');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('RepúblicaCheca','CHECA','CZE');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('RepúblicadeMacedonia','MACEDONIA','MKD');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('RepúblicadelCongo','CONGOLEÑA','COG');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('RepúblicaDemocráticadelCongo','CONGOLEÑA','COD');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('RepúblicaDominicana','DOMINICANA','DOM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('RepúblicaSudafricana','SUDAFRICANA','ZAF');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Ruanda','RUANDÉSA','RWA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Rumanía','RUMANA','ROU');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Rusia','RUSA','RUS');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Samoa','SAMOANA','WSM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('SanCristóbalyNieves','CRISTOBALEÑA','KNA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('SanMarino','SANMARINENSE','SMR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('SanVicenteylasGranadinas','SANVICENTINA','VCT');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('SantaLucía','SANTALUCENSE','LCA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('SantoToméyPríncipe','SANTOTOMENSE','STP');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Senegal','SENEGALÉSA','SEN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Serbia','SERBIA','SRB');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Seychelles','SEYCHELLENSE','SYC');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('SierraLeona','SIERRALEONÉSA','SLE');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Singapur','SINGAPURENSE','SGP');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Siria','SIRIA','SYR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Somalia','SOMALÍ','SOM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('SriLanka','CEILANÉSA','LKA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Suazilandia','SUAZI','SWZ');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('SudándelSur','SURSUDANÉSA','SSD');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Sudán','SUDANÉSA','SDN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Suecia','SUECA','SWE');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Suiza','SUIZA','CHE');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Surinam','SURINAMESA','SUR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Tailandia','TAILANDÉSA','THA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Tanzania','TANZANA','TZA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Tayikistán','TAYIKA','TJK');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('TimorOriental','TIMORENSE','TLS');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Togo','TOGOLÉSA','TGO');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Tonga','TONGANA','TON');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('TrinidadyTobago','TRINITENSE','TTO');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Túnez','TUNECINA','TUN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Turkmenistán','TURCOMANA','TKM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Turquía','TURCA','TUR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Tuvalu','TUVALUANA','TUV');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Ucrania','UCRANIANA','UKR');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Uganda','UGANDÉSA','UGA');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Uruguay','URUGUAYA','URY');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Uzbekistán','UZBEKA','UZB');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Vanuatu','VANUATUENSE','VUT');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Venezuela','VENEZOLANA','VEN');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Vietnam','VIETNAMITA','VNM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Yemen','YEMENÍ','YEM');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Yibuti','YIBUTIANA','DJI');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Zambia','ZAMBIANA','ZMB');\r\n"
				+ "INSERT INTO`nacionalidad`(`PAIS_NAC`,`GENTILICIO_NAC`,`ISO_NAC`)VALUES('Zimbabue','ZIMBABUENSE','ZWE');";

		cont = 0;

		nacionalidad = "";
		pais = "";
		dato = "";

	}

	public ObservableList<String> getNacionalidadesParaCombo() {

		for (int i = 0; i < dato.length(); i++) {

			if (dato.charAt(i) == '\'') {

				cont++;

			}

			if (nacionalidad.length() != 0 && dato.charAt(i) != '\'') {

				if (dato.charAt(i) == 'É') {

					nacionalidad += 'E';

				} else {

					nacionalidad += dato.charAt(i);

				}

			}

			if (cont == 4) {

				nacionalidadesParaCombo.add(nacionalidad.toLowerCase());
				nacionalidad = "";

			}

			if (dato.charAt(i) == '\n') {

				cont = 0;

			}

		}

		return nacionalidadesParaCombo;

	}

	public ObservableList<String> getPaisesParaCombo() {

		for (int i = 0; i < dato.length(); i++) {

			if (dato.charAt(i) == '\'') {

				cont++;

			}

			if (pais.length() != 0 && dato.charAt(i) != '\'') {

				pais += dato.charAt(i);

			}

			if (cont == 2) {

				paisesParaCombo.add(pais);
				pais = "";
				cont = 0;

			}

			if (dato.charAt(i) == '\n') {

				cont = 0;

			}

		}

		return paisesParaCombo;

	}

}
