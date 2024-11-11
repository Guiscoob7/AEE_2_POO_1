import javax.swing.*; // 📦 Importa as bibliotecas necessárias para construir a interface gráfica

public class JanelaRemoverArte extends JFrame { // 🖥️ Classe para remover uma arte da galeria
  private Galeria galeria; // 🖼️ Instância da galeria de artes
  private JanelaPrincipal janelaPrincipal; // 🖥️ Referência para a janela principal

  public JanelaRemoverArte(Galeria galeria, JanelaPrincipal janelaPrincipal) { // 🏗️ Construtor
    this.galeria = galeria; // 🖼️ Recebe a galeria
    this.janelaPrincipal = janelaPrincipal; // 🖥️ Recebe a janela principal
    inicializarUI(); // 🛠️ Inicializa a interface gráfica
  }

  private void inicializarUI() { // 🛠️ Configura a interface gráfica
    setTitle("Remover Arte"); // 📑 Define o título da janela
    setSize(400, 300); // 📏 Define o tamanho da janela
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 🛑 Fecha a janela ao clicar no 'X'

    // Criar a lista de artes
    JList<Arte> listaArtes = new JList<>(galeria.getArtes().toArray(new Arte[0])); // 🖼️ Cria a lista com objetos Arte
    listaArtes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 🖱️ Permite selecionar apenas uma arte

    JScrollPane scrollPane = new JScrollPane(listaArtes); // 📜 Adiciona a lista ao JScrollPane
    add(scrollPane); // 📥 Adiciona o scroll ao painel da janela

    // Botão para remover a arte selecionada
    JButton btnRemover = new JButton("Remover Arte"); // ❌ Cria o botão 'Remover Arte'
    btnRemover.addActionListener(e -> { // ⚙️ Ação ao clicar no botão
      Arte arteSelecionada = listaArtes.getSelectedValue(); // 🔍 Obtém a arte selecionada
      if (arteSelecionada != null) {
        galeria.removerArte(arteSelecionada); // 🗑️ Remove a arte da galeria
        JOptionPane.showMessageDialog(this, "Arte removida com sucesso!"); // 📝 Exibe mensagem de sucesso
        janelaPrincipal.mostrarGaleria("Gótica"); // 🖼️ Atualiza a galeria para exibir as artes restantes
        dispose(); // 🗑️ Fecha a janela de remoção
      } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecione uma arte para remover.", "Erro", JOptionPane.ERROR_MESSAGE); // ⚠️ Alerta se nenhuma arte for selecionada
      }
    });

    JPanel painelBotoes = new JPanel(); // 🗂️ Cria o painel para os botões
    painelBotoes.add(btnRemover); // 📥 Adiciona o botão ao painel de botões
    add(painelBotoes, "South"); // 📥 Adiciona o painel de botões na parte inferior da janela
  }
}
