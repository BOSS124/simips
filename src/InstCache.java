import javax.swing.JTable;

public class InstCache extends JTable {
	private static final int cont = 32;
	private static final int bytesInst = 4;

	private static final String[] colunas = {"End", "Inst", "op1", "op2", "op3"};
	private Instrucao instrucoes[];

	public InstCache() {
		
	}
}