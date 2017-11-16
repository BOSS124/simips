import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class InstCache extends JTable {
	private static final int cont = 32;
	private static final int bytesInst = 4;

	private static final String[] colunas = {"End", "Inst", "op1", "op2", "op3"};
	private Instrucao instrucoes[];

	public InstCache() {
		super(new AbstractTableModel() {
			public int getRowCount() {
				return InstCache.count;
			}
			public int getColumnCount() {
				return InstCache.colunas.length;
			}
			public Object getValueAt(int row, int column) {
				return instrucoes[row];
			}
		});

		instrucoes = new Instrucao[InstCache.cont];
		for(int i = 0; i < InstCache.cont; i++) {
			instrucoes[i] = new Instrucao(); //completar para inicializar todas instruções com nops
		}
	}
}