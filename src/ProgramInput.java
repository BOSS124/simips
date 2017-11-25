import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import mips.InstCache;

public class ProgramInput extends JFrame implements ActionListener {
	private InstCache instCache;
	private JTextArea textArea;
	private JButton salvarBtn;
	private JButton cancelarBtn;

	public ProgramInput(InstCache instCache) {
		super("Instruções a executar");
		this.instCache = instCache;

		textArea = new JTextArea(InstCache.cont, 50);
		textArea.setEditable(true);

		salvarBtn = new JButton("Salvar");
		cancelarBtn = new JButton("Cancelar");
		salvarBtn.addActionListener(this);
		cancelarBtn.addActionListener(this);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea), BorderLayout.PAGE_START);

		JPanel opcoes = new JPanel(new FlowLayout());
		opcoes.add(salvarBtn);
		opcoes.add(cancelarBtn);

		add(opcoes, BorderLayout.PAGE_END);
		pack();
	}

	public void mostrar() {
		String instrucoes = instCache.getInstrucoes();
		textArea.setText(instrucoes);
		setVisible(true);
		requestFocus();
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == salvarBtn) {
			String[] instrucoes = textArea.getText().split("\n");
			for(int i = 0; i < InstCache.cont; i++) {
				if(i >= instrucoes.length) {
					instCache.setInstrucao(i, "NOP");
				}
				else {
					instCache.setInstrucao(i, instrucoes[i]);
				}
			}

		}
		hide();
	}
}