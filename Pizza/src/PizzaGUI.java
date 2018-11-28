import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.ArrayList;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class PizzaGUI extends JFrame
{

	private JPanel contentPane;
	private JLabel lblPizza;
	private JComboBox<Pizza> comboBoxPizza;
	private JLabel lblGre;
	private JComboBox<Double> comboBoxSize;
	private JLabel lblNewLabel;
	private JTextField textFieldExtras;
	private JTextField textFieldExtrakosten;
	private JButton btnHinzufgen;
	private JButton btnEntfernen;
	private JButton btnHardcopy;
	private JButton btnDrucken;
	private JLabel lblGesamtpreis;
	private JTextField textFieldGesamtpreis;
	private JList<?> list;

	private ArrayList<Pizza> pizzen = new ArrayList<Pizza>();

	private DefaultListModel<Pizza> pizzaListe = new DefaultListModel<Pizza>();
	private JButton btnffnen;
	private JButton btnSpeichern;

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
					PizzaGUI frame = new PizzaGUI();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Methods
	 */

	private void ladePizzen()
	{

		pizzen.add(new Pizza("Diavola", 9, 11, 13));
		pizzen.add(new Pizza("Diablo", 13, 15, 17));
		pizzen.add(new Pizza("Hawai", 9, 10, 11));
		pizzen.add(new Pizza("Margahrita", 6, 7, 8));
		pizzen.add(new Pizza("Salami", 8, 9, 10));

		for (Pizza p : pizzen)
		{
			comboBoxPizza.addItem(p);
		}
	}

	private void lesenNeu()
	{
		FileSystem fs = FileSystems.getDefault(); 
		Path path = fs.getPath("Bestellung.txt");
		try
		{
			BufferedReader in = Files.newBufferedReader(path,StandardCharsets.UTF_8);
			Pizza p;
			
			while(in.readLine() != null)
			{
				p = new Pizza();
				String[] data = in.readLine().split(";");
				p.setName(data[0]);
				ArrayList<Double> preise = new ArrayList<Double>();
				preise.add(Double.parseDouble(data[1]));
				preise.add(Double.parseDouble(data[2]));
				preise.add(Double.parseDouble(data[3]));
				p.setPreise(preise);
				
				
				pizzaListe.addElement(p);
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void schreiben()
	{
		
	}

	private void errecheGesmatpreis()
	{
		double temp = 0;
		for(int i = 0; i < pizzaListe.size()-1;i++)
		{
			temp += pizzaListe.getElementAt(i).getExtrakosten();
			temp += pizzaListe.getElementAt(i).getPreisAktuell();
		}
		textFieldGesamtpreis.setText("" + temp);
	}

	/**
	 * Create the frame.
	 */
	public PizzaGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 95, 184, 39, 115, 0 };
		gbl_contentPane.rowHeights = new int[] { 20, 21, 21, 0, 0, 0, 0, 0, 23, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_lblPizza = new GridBagConstraints();
		gbc_lblPizza.insets = new Insets(0, 0, 5, 5);
		gbc_lblPizza.gridx = 0;
		gbc_lblPizza.gridy = 0;
		contentPane.add(getLblPizza(), gbc_lblPizza);
		GridBagConstraints gbc_comboBoxPizza = new GridBagConstraints();
		gbc_comboBoxPizza.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPizza.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPizza.gridx = 1;
		gbc_comboBoxPizza.gridy = 0;
		contentPane.add(getComboBoxPizza(), gbc_comboBoxPizza);
		GridBagConstraints gbc_lblGre = new GridBagConstraints();
		gbc_lblGre.insets = new Insets(0, 0, 5, 5);
		gbc_lblGre.gridx = 2;
		gbc_lblGre.gridy = 0;
		contentPane.add(getLblGre(), gbc_lblGre);
		GridBagConstraints gbc_comboBoxSize = new GridBagConstraints();
		gbc_comboBoxSize.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxSize.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSize.gridx = 3;
		gbc_comboBoxSize.gridy = 0;
		contentPane.add(getComboBoxSize(), gbc_comboBoxSize);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(getLblNewLabel(), gbc_lblNewLabel);
		GridBagConstraints gbc_textFieldExtras = new GridBagConstraints();
		gbc_textFieldExtras.gridwidth = 2;
		gbc_textFieldExtras.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldExtras.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldExtras.gridx = 1;
		gbc_textFieldExtras.gridy = 1;
		contentPane.add(getTextFieldExtras(), gbc_textFieldExtras);
		GridBagConstraints gbc_textFieldExtrakosten = new GridBagConstraints();
		gbc_textFieldExtrakosten.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldExtrakosten.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldExtrakosten.gridx = 3;
		gbc_textFieldExtrakosten.gridy = 1;
		contentPane.add(getTextFieldExtrakosten(), gbc_textFieldExtrakosten);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 3;
		gbc_list.gridheight = 6;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		contentPane.add(getList(), gbc_list);
		GridBagConstraints gbc_btnHinzufgen = new GridBagConstraints();
		gbc_btnHinzufgen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHinzufgen.insets = new Insets(0, 0, 5, 0);
		gbc_btnHinzufgen.gridx = 3;
		gbc_btnHinzufgen.gridy = 2;
		contentPane.add(getBtnHinzufgen(), gbc_btnHinzufgen);
		GridBagConstraints gbc_btnEntfernen = new GridBagConstraints();
		gbc_btnEntfernen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEntfernen.insets = new Insets(0, 0, 5, 0);
		gbc_btnEntfernen.gridx = 3;
		gbc_btnEntfernen.gridy = 3;
		contentPane.add(getBtnEntfernen(), gbc_btnEntfernen);
		GridBagConstraints gbc_btnHardcopy = new GridBagConstraints();
		gbc_btnHardcopy.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHardcopy.insets = new Insets(0, 0, 5, 0);
		gbc_btnHardcopy.gridx = 3;
		gbc_btnHardcopy.gridy = 4;
		contentPane.add(getBtnHardcopy(), gbc_btnHardcopy);
		GridBagConstraints gbc_btnDrucken = new GridBagConstraints();
		gbc_btnDrucken.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDrucken.insets = new Insets(0, 0, 5, 0);
		gbc_btnDrucken.gridx = 3;
		gbc_btnDrucken.gridy = 5;
		contentPane.add(getBtnDrucken(), gbc_btnDrucken);
		GridBagConstraints gbc_btnffnen = new GridBagConstraints();
		gbc_btnffnen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnffnen.insets = new Insets(0, 0, 5, 0);
		gbc_btnffnen.gridx = 3;
		gbc_btnffnen.gridy = 6;
		contentPane.add(getBtnffnen(), gbc_btnffnen);
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSpeichern.insets = new Insets(0, 0, 5, 0);
		gbc_btnSpeichern.gridx = 3;
		gbc_btnSpeichern.gridy = 7;
		contentPane.add(getBtnSpeichern(), gbc_btnSpeichern);
		GridBagConstraints gbc_lblGesamtpreis = new GridBagConstraints();
		gbc_lblGesamtpreis.anchor = GridBagConstraints.EAST;
		gbc_lblGesamtpreis.insets = new Insets(0, 0, 0, 5);
		gbc_lblGesamtpreis.gridx = 0;
		gbc_lblGesamtpreis.gridy = 8;
		contentPane.add(getLblGesamtpreis(), gbc_lblGesamtpreis);
		GridBagConstraints gbc_textFieldGesamtpreis = new GridBagConstraints();
		gbc_textFieldGesamtpreis.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldGesamtpreis.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGesamtpreis.gridx = 1;
		gbc_textFieldGesamtpreis.gridy = 8;
		contentPane.add(getTextFieldGesamtpreis(), gbc_textFieldGesamtpreis);

		ladePizzen();
	}

	private JLabel getLblPizza()
	{
		if (lblPizza == null)
		{
			lblPizza = new JLabel("Pizza");
		}
		return lblPizza;
	}

	private JComboBox getComboBoxPizza()
	{
		if (comboBoxPizza == null)
		{
			comboBoxPizza = new JComboBox();
			comboBoxPizza.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					comboBoxSize.removeAllItems();

					Pizza temp = (Pizza) comboBoxPizza.getSelectedItem();

					for (double preis : temp.getPreise())
					{
						comboBoxSize.addItem(preis);
					}
				}
			});
		}
		return comboBoxPizza;
	}

	private JLabel getLblGre()
	{
		if (lblGre == null)
		{
			lblGre = new JLabel("Gr\u00F6\u00DFe:");
		}
		return lblGre;
	}

	private JComboBox<Double> getComboBoxSize()
	{
		if (comboBoxSize == null)
		{
			comboBoxSize = new JComboBox();
		}
		return comboBoxSize;
	}

	private JLabel getLblNewLabel()
	{
		if (lblNewLabel == null)
		{
			lblNewLabel = new JLabel("Extras");
		}
		return lblNewLabel;
	}

	private JTextField getTextFieldExtras()
	{
		if (textFieldExtras == null)
		{
			textFieldExtras = new JTextField();
			textFieldExtras.setColumns(10);
		}
		return textFieldExtras;
	}

	private JTextField getTextFieldExtrakosten()
	{
		if (textFieldExtrakosten == null)
		{
			textFieldExtrakosten = new JTextField();
			textFieldExtrakosten.setColumns(10);
		}
		return textFieldExtrakosten;
	}

	private JButton getBtnHinzufgen()
	{
		if (btnHinzufgen == null)
		{
			btnHinzufgen = new JButton("Hinzuf\u00FCgen");
			btnHinzufgen.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					pizzaListe.addElement((Pizza) comboBoxPizza.getSelectedItem());
				}
			});
		}
		return btnHinzufgen;
	}

	private JButton getBtnEntfernen()
	{
		if (btnEntfernen == null)
		{
			btnEntfernen = new JButton("Entfernen");
			btnEntfernen.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					pizzaListe.removeElement(list.getSelectedValue());
				}
			});
		}
		return btnEntfernen;
	}

	private JButton getBtnHardcopy()
	{
		if (btnHardcopy == null)
		{
			btnHardcopy = new JButton("Hardcopy");
		}
		return btnHardcopy;
	}

	private JButton getBtnDrucken()
	{
		if (btnDrucken == null)
		{
			btnDrucken = new JButton("Drucken");
		}
		return btnDrucken;
	}

	private JLabel getLblGesamtpreis()
	{
		if (lblGesamtpreis == null)
		{
			lblGesamtpreis = new JLabel("Gesamtpreis:");
		}
		return lblGesamtpreis;
	}

	private JTextField getTextFieldGesamtpreis()
	{
		if (textFieldGesamtpreis == null)
		{
			textFieldGesamtpreis = new JTextField();
			textFieldGesamtpreis.setColumns(10);
		}
		return textFieldGesamtpreis;
	}

	private JList getList()
	{
		if (list == null)
		{
			list = new JList(pizzaListe);
			list.addListSelectionListener(new ListSelectionListener()
			{
				public void valueChanged(ListSelectionEvent arg0)
				{
					errecheGesmatpreis();
				}
			});
		}
		return list;
	}

	private JButton getBtnffnen()
	{
		if (btnffnen == null)
		{
			btnffnen = new JButton("\u00D6ffnen");
			btnffnen.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					lesenNeu();
				}
			});
		}
		return btnffnen;
	}

	private JButton getBtnSpeichern()
	{
		if (btnSpeichern == null)
		{
			btnSpeichern = new JButton("Speichern");
			btnSpeichern.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					schreiben();
				}
			});
		}
		return btnSpeichern;
	}
}
