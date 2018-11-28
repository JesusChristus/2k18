import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class PersonenGUI extends JFrame
{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textFieldDatei;
	private JTextField textFieldPersonalNummer;
	private JTextField textFieldName;
	private JTextField textFieldGehalt;
	private JTextField textFieldGebDat;
	private JButton btnSchreiben;
	private JButton btnLesen;
	private JButton btnAbbruch;
	private JList list;
	private DefaultListModel<Person> listModel = new DefaultListModel<Person>();
	private File f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					PersonenGUI frame = new PersonenGUI();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonenGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 46, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(getLblNewLabel(), gbc_lblNewLabel);
		GridBagConstraints gbc_textFieldDatei = new GridBagConstraints();
		gbc_textFieldDatei.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDatei.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDatei.gridx = 1;
		gbc_textFieldDatei.gridy = 0;
		contentPane.add(getTextFieldDatei(), gbc_textFieldDatei);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 5;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 0;
		contentPane.add(getList(), gbc_list);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(getLblNewLabel_1(), gbc_lblNewLabel_1);
		GridBagConstraints gbc_textFieldPersonalNummer = new GridBagConstraints();
		gbc_textFieldPersonalNummer.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPersonalNummer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPersonalNummer.gridx = 1;
		gbc_textFieldPersonalNummer.gridy = 1;
		contentPane.add(getTextFieldPersonalNummer(), gbc_textFieldPersonalNummer);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(getLblNewLabel_2(), gbc_lblNewLabel_2);
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 2;
		contentPane.add(getTextFieldName(), gbc_textFieldName);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(getLblNewLabel_3(), gbc_lblNewLabel_3);
		GridBagConstraints gbc_textFieldGehalt = new GridBagConstraints();
		gbc_textFieldGehalt.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGehalt.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGehalt.gridx = 1;
		gbc_textFieldGehalt.gridy = 3;
		contentPane.add(getTextFieldGehalt(), gbc_textFieldGehalt);
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(getLblNewLabel_4(), gbc_lblNewLabel_4);
		GridBagConstraints gbc_textFieldGebDat = new GridBagConstraints();
		gbc_textFieldGebDat.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGebDat.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGebDat.gridx = 1;
		gbc_textFieldGebDat.gridy = 4;
		contentPane.add(getTextFieldGebDat(), gbc_textFieldGebDat);
		GridBagConstraints gbc_btnSchreiben = new GridBagConstraints();
		gbc_btnSchreiben.insets = new Insets(0, 0, 0, 5);
		gbc_btnSchreiben.gridx = 0;
		gbc_btnSchreiben.gridy = 5;
		contentPane.add(getBtnSchreiben(), gbc_btnSchreiben);
		GridBagConstraints gbc_btnAbbruch = new GridBagConstraints();
		gbc_btnAbbruch.insets = new Insets(0, 0, 0, 5);
		gbc_btnAbbruch.gridx = 1;
		gbc_btnAbbruch.gridy = 5;
		contentPane.add(getBtnAbbruch(), gbc_btnAbbruch);
		GridBagConstraints gbc_btnLesen = new GridBagConstraints();
		gbc_btnLesen.gridx = 2;
		gbc_btnLesen.gridy = 5;
		contentPane.add(getBtnLesen(), gbc_btnLesen);
	}

	private JLabel getLblNewLabel()
	{
		if (lblNewLabel == null)
		{
			lblNewLabel = new JLabel("Datei");
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1()
	{
		if (lblNewLabel_1 == null)
		{
			lblNewLabel_1 = new JLabel("Pnr:");
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2()
	{
		if (lblNewLabel_2 == null)
		{
			lblNewLabel_2 = new JLabel("Name:");
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3()
	{
		if (lblNewLabel_3 == null)
		{
			lblNewLabel_3 = new JLabel("Gehalt:");
		}
		return lblNewLabel_3;
	}

	private JLabel getLblNewLabel_4()
	{
		if (lblNewLabel_4 == null)
		{
			lblNewLabel_4 = new JLabel("Geburtsdatum:");
		}
		return lblNewLabel_4;
	}

	private JTextField getTextFieldDatei()
	{
		if (textFieldDatei == null)
		{
			textFieldDatei = new JTextField();
			textFieldDatei.setColumns(10);
		}
		return textFieldDatei;
	}

	private JTextField getTextFieldPersonalNummer()
	{
		if (textFieldPersonalNummer == null)
		{
			textFieldPersonalNummer = new JTextField();
			textFieldPersonalNummer.setColumns(10);
		}
		return textFieldPersonalNummer;
	}

	private JTextField getTextFieldName()
	{
		if (textFieldName == null)
		{
			textFieldName = new JTextField();
			textFieldName.setColumns(10);
		}
		return textFieldName;
	}

	private JTextField getTextFieldGehalt()
	{
		if (textFieldGehalt == null)
		{
			textFieldGehalt = new JTextField();
			textFieldGehalt.setColumns(10);
		}
		return textFieldGehalt;
	}

	private JTextField getTextFieldGebDat()
	{
		if (textFieldGebDat == null)
		{
			textFieldGebDat = new JTextField();
			textFieldGebDat.setColumns(10);
		}
		return textFieldGebDat;
	}

	private JButton getBtnSchreiben()
	{
		if (btnSchreiben == null)
		{
			btnSchreiben = new JButton("Schreiben");
			btnSchreiben.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					schreiben();
					
				}
			});
		}
		return btnSchreiben;
	}

	private JButton getBtnLesen()
	{
		if (btnLesen == null)
		{
			btnLesen = new JButton("Lesen");
			btnLesen.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					lesen();
				}
			});
		}
		return btnLesen;
	}

	private JButton getBtnAbbruch()
	{
		if (btnAbbruch == null)
		{
			btnAbbruch = new JButton("Abbruch");
			btnAbbruch.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					textboxenLeeren();
				}
			});
		}
		return btnAbbruch;
	}


	private JList getList()
	{
		if (list == null)
		{
			list = new JList(listModel);
			list.addListSelectionListener(new ListSelectionListener()
			{
				public void valueChanged(ListSelectionEvent arg0)
				{
					textboxenFuellen();					
				}
			});
		}
		return list;
	}
	
	
	private void lesen()
	{
		listModel.removeAllElements();
		Person p;
		try
		{
			File f = new File(textFieldDatei.getText());
			DateiHandler dh = new DateiHandler(f);
			do
			{
				p = dh.lesen();
				listModel.addElement(p);
			} while (p != null);

			dh.schliessen();	
		} catch (NullPointerException e)
		{
			e.printStackTrace();
			System.out.println("404 File not Found");
		}
	}
	
	private void textboxenLeeren()
	{
		textFieldPersonalNummer.setText("");
		textFieldName.setText("");
		textFieldGehalt.setText("");
		textFieldGebDat.setText("");
		textFieldDatei.setText("");
		textFieldDatei.grabFocus();
		listModel.removeAllElements();
	}
	
	private void textboxenFuellen()
	{
		if(list.getSelectedValue() != null)
		{
			Person temp = (Person) list.getSelectedValue();
			textFieldGebDat.setText(""+temp.getGebDat());
			textFieldGehalt.setText("" + temp.getGehalt());
			textFieldName.setText("" + temp.getName());
			textFieldPersonalNummer.setText("" + temp.getPersonalNr());
		}
	}
	
	private void schreiben()
	{
		listModel.getElementAt(list.getSelectedIndex()).setGebDat(textFieldGebDat.getText()); 
		listModel.getElementAt(list.getSelectedIndex()).setGehalt(Double.valueOf(textFieldGehalt.getText()).doubleValue());
		listModel.getElementAt(list.getSelectedIndex()).setName(textFieldName.getText());
		listModel.getElementAt(list.getSelectedIndex()).setPersonalNr(Integer.valueOf(textFieldPersonalNummer.getText()).intValue());
		
		try
		{
			BufferedWriter wr = new BufferedWriter(new FileWriter("Personen.dta",false));
			for(int i = 0; i < listModel.size()-1;i++)
			{
				wr.write(listModel.elementAt(i).getName()+";");
				wr.write(listModel.elementAt(i).getGebDat()+";");
				wr.write(String.valueOf(listModel.elementAt(i).getGehalt()).toString()+";");
				wr.newLine();
			}
			wr.close();
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}catch(NullPointerException npe)
		{
			f = new File("test.txt");
		}
	}

}
