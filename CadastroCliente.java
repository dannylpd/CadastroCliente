import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CadastroCliente {
public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        JFrame frame = new JFrame("Lista de Clientes");

        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Telefone");
        model.addColumn("Email");
        model.addColumn("Logradouro");
        model.addColumn("Numero");
        model.addColumn("Complemento");
        model.addColumn("Bairro");
        model.addColumn("Cidade");
        model.addColumn("Estado");
        model.addColumn("Cep");
        table.setModel(model);

        JButton cadastrarButton = new JButton("Cadastrar Cliente");

        cadastrarButton.addActionListener(e -> {
            JFrame cadastroFrame = new JFrame("Cadastro de Cliente");
            cadastroFrame.setLayout(new GridLayout(11, 2));

            JLabel nomeLabel = new JLabel("Nome:");
            JTextField nomeField = new JTextField();
            cadastroFrame.add(nomeLabel);
            cadastroFrame.add(nomeField);

            JLabel telefoneLabel = new JLabel("Telefone:");
            JTextField telefoneField = new JTextField();
            cadastroFrame.add(telefoneLabel);
            cadastroFrame.add(telefoneField);

            JLabel emailLabel = new JLabel("Email:");
            JTextField emailField = new JTextField();
            cadastroFrame.add(emailLabel);
            cadastroFrame.add(emailField);

            JLabel logradouroLabel = new JLabel("Logradouro:");
            JTextField logradouroField = new JTextField();
            cadastroFrame.add(logradouroLabel);
            cadastroFrame.add(logradouroField);

            JLabel numeroLabel = new JLabel("Numero:");
            JTextField numeroField = new JTextField();
            cadastroFrame.add(numeroLabel);
            cadastroFrame.add(numeroField);

            JLabel complementoLabel = new JLabel("Complemento:");
            JTextField complementoField = new JTextField();
            cadastroFrame.add(complementoLabel);
            cadastroFrame.add(complementoField);

            JLabel bairroLabel = new JLabel("Bairro:");
            JTextField bairroField = new JTextField();
            cadastroFrame.add(bairroLabel);
            cadastroFrame.add(bairroField);

            JLabel cidadeLabel = new JLabel("Cidade:");
            JTextField cidadeField = new JTextField();
            cadastroFrame.add(cidadeLabel);
            cadastroFrame.add(cidadeField);

            JLabel estadoLabel = new JLabel("Estado:");
            String[] estados = {"Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
            JComboBox<String> estadoComboBox = new JComboBox<>(estados);
            cadastroFrame.add(estadoLabel);
            cadastroFrame.add(estadoComboBox);

            JLabel cepLabel = new JLabel("Cep:");
            JTextField cepField = new JTextField();
            cadastroFrame.add(cepLabel);
            cadastroFrame.add(cepField);

            cadastroFrame.setSize(400, 300);
            cadastroFrame.setVisible(true);

            JButton salvarButton = new JButton("Salvar");
            salvarButton.addActionListener(evento -> {
                Cliente novoCliente = new Cliente();
                novoCliente.setNome(nomeField.getText());
                novoCliente.setTelefone(telefoneField.getText());
                novoCliente.setEmail(emailField.getText());
                novoCliente.setLogradouro(logradouroField.getText());
                novoCliente.setNumero(numeroField.getText());
                novoCliente.setComplemento(complementoField.getText());
                novoCliente.setBairro(bairroField.getText());
                novoCliente.setCidade(cidadeField.getText());
                novoCliente.setEstado((String) estadoComboBox.getSelectedItem());
                novoCliente.setCep(cepField.getText());

                clientes.add(novoCliente);

                DefaultTableModel modelo = (DefaultTableModel) table.getModel();
                modelo.addRow(new Object[]{novoCliente.getNome(), novoCliente.getTelefone(), novoCliente.getEmail(), novoCliente.getLogradouro(), novoCliente.getNumero(), novoCliente.getComplemento(), novoCliente.getBairro(), novoCliente.getCidade(), novoCliente.getEstado(), novoCliente.getCep()});

                cadastroFrame.dispose();
            });

            cadastroFrame.add(salvarButton);

            cadastroFrame.setSize(400, 300);
            cadastroFrame.setVisible(true);

        });

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(cadastrarButton, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}