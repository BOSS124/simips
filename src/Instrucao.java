public class Instrucao {
	public static final int TIPO_R = 0;
	public static final int TIPO_I = 1;
	public static final int TIPO_J = 2;
	public static final int TIPO_DESCONHECIDO = -1;

	private int tipo;
	private String reg1;
	private String reg2;
	private String reg3;

	public Instrucao(String mnemonico) {
		if(mnemonico.equalsIgnoreCase("ADD")) {

		}
		else if(mnemonico.equalsIgnoreCase("SUB")) {

		}
		else if(mnemonico.equalsIgnoreCase("AND")) {

		}
		else if(mnemonico.equalsIgnoreCase("OR")) {

		}
		else {
			
		}
	}
}