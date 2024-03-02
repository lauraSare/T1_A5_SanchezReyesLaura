import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class VentanaInicio extends JFrame implements ActionListener,KeyListener{
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	JLabel lblT,lbl1,lblEs;
	JTextField txt1,resultado;
	double res;
	boolean band1=true;
	boolean band2=true;
	byte verifPuntos = 0, verifNumMenos = 0;
	Operaciones obj= new Operaciones();
	JComboBox<String> op,op2 ;
	JButton btnConvertir;
	
	public VentanaInicio() {
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Conversor Temperatura");
		setLocationRelativeTo(null);
		setVisible(true);

		lblT= new JLabel("Conversor de Temperaturas");
		MetodoLlenado(lblT, 0, 0, 3, 1);
		
		txt1= new JTextField(10);
		gbc.fill= GridBagConstraints.BOTH;
		MetodoLlenado(txt1, 0, 1,2, 1);
		
		txt1.addKeyListener(this);

		op=new JComboBox<String>();
		op.setEnabled(false);
		op.addItem("Selecciona opcion..");
		op.addItem("°C");
		op.addItem("°F");
		op.addItem("°K");
		op.addItem("°R");
		op.addActionListener(this);
		gbc.fill= GridBagConstraints.HORIZONTAL;
		MetodoLlenado(op, 2,1,2, 1);

		lbl1= new JLabel("A: ");
		MetodoLlenado(lbl1, 0, 2, 1, 1);
		gbc.fill= GridBagConstraints.HORIZONTAL;

		op2=new JComboBox<String>();
		op2.setEnabled(false);
		MetodoLlenado(op2, 1,2,2, 1);
		op2.addActionListener(this);
		
		resultado= new JTextField(10);
		resultado.setEditable(false);
		gbc.fill= GridBagConstraints.HORIZONTAL;
		MetodoLlenado(resultado,3, 2,2,1);
		pack();

	}
	public void MetodoLlenado(Component c,int gx,int gy,int gw,int gh) {
		gbc.gridx=gx;
		gbc.gridy=gy;
		gbc.gridwidth=gw;
		gbc.gridheight=gh;
		gbl.setConstraints(c, gbc);
		add(c);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Component c = (Component) e.getSource();
		if(c == op && band1 == true) {
			band1 = false;
			op2.removeAllItems();
			if(op.getSelectedIndex() == 0) {
				resultado.setText("");
			}else {
				for (int i = 0; i<op.getItemCount();i++) {
					if(op.getSelectedIndex() == i) {
						
					}else {
						op2.addItem(op.getItemAt(i));
					}
				}
			}
			band1 = true;
			
		}else if(c == op2 && band2 == true) {
			band2 = false;
			if(op2.getSelectedIndex() == 0) {
				resultado.setText("");
			}else if(op.getSelectedIndex() == 1) {
				if(op2.getSelectedIndex() == 1) {
					res=obj.CelciusFahrenheit(Double.parseDouble(txt1.getText()));
					resultado.setText(String.valueOf(res));
				}else if(op2.getSelectedIndex() == 2) {
					res=obj.CelciusKelvin(Double.parseDouble(txt1.getText()));
					resultado.setText(String.valueOf(res));
				}else if(op2.getSelectedIndex() == 3) {
					res=obj.CelciusRankin(Double.parseDouble(txt1.getText()));
					resultado.setText(String.valueOf(res));
				}
			}else if(op.getSelectedIndex() == 2) {
				if(op2.getSelectedIndex() == 1) {
					res=obj.FahrenheitCelcius(Double.parseDouble(txt1.getText()));
					resultado.setText(String.valueOf(res));
				}else if(op2.getSelectedIndex() == 2) {
					res=obj.FahrenheitKelvin(Double.parseDouble(txt1.getText()));
					resultado.setText(String.valueOf(res));
				}else if(op2.getSelectedIndex() == 3) {
					res=obj.FahrenheitRankin(Double.parseDouble(txt1.getText()));
					resultado.setText(String.valueOf(res));
				}
			}else if(op.getSelectedIndex() == 3) {
				if(op2.getSelectedIndex() == 1) {
					res=obj.KelvinCelcius(Double.parseDouble(txt1.getText()));
					resultado.setText(String.valueOf(res));
				}else if(op2.getSelectedIndex() == 2) {
					res=obj.KelvinFahrenheit(Double.parseDouble(txt1.getText()));
					resultado.setText(String.valueOf(res));
				}else if(op2.getSelectedIndex() == 3) {
					res=obj.KelvinRankin(Double.parseDouble(txt1.getText()));
					resultado.setText(String.valueOf(res));
				}
			}else if(op.getSelectedIndex() == 4) {
				if(op2.getSelectedIndex() == 1) {
					res=obj.RankinCelcius(Double.parseDouble(txt1.getText()));
					resultado.setText(String.valueOf(res));
				}else if(op2.getSelectedIndex() == 2) {
					res=obj.RankinFahrenheit(Double.parseDouble(txt1.getText()));
					resultado.setText(String.valueOf(res));
				}else if(op2.getSelectedIndex() == 3) {
					res=obj.RankinKelvin(Double.parseDouble(txt1.getText()));
					resultado.setText(String.valueOf(res));
				}
			}
			band2 = true;
		}}
	@Override
	public void keyTyped(KeyEvent e) {
		int c = e.getKeyChar();
		if(!(c=='.'||c=='-'||c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||
				c=='6'||c=='7'||c=='8'||c=='9')) { 
			e.consume();
		}else {
			if(c=='.') {
				if(txt1.getText().length()==0) {
					e.consume();
				}else if(txt1.getText().length()==1) {
					if(txt1.getText().charAt(0)=='-') {
						e.consume();
					}
				}else if(verifPuntos != 0) {
					e.consume();
				}else {
					verifPuntos = 1;
				}
			}
			if(c=='-') {
				if(txt1.getText().length()!=0) {
					e.consume();
				}
			}
		}

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(!txt1.getText().contains(".")) {
			verifPuntos = 0;
		}
		if(txt1.getText().length()==0) {
			op.setEnabled(false);
			op2.setEnabled(false);
			resultado.setText("");
		}else if(txt1.getText().charAt(0)!='-' || (txt1.getText().charAt(0)=='-' && txt1.getText().length()>=2)) {
			op.setEnabled(true);
			op2.setEnabled(true);
		}else {
			op.setEnabled(false);
			op2.setEnabled(false);
		}

	}
}
public class ConversorTemperaturas {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaInicio();
			}
		});
	}

}