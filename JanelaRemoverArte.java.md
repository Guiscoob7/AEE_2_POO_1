```java
import javax.swing.*; // 📦 Importa as bibliotecas necessárias para construir a interface gráfica

public class JanelaRemoverArte extends JFrame { // 🖥️ Classe para remover uma arte da galeria
  private Galeria galeria; // 🖼️ Instância da galeria de artes
  private JanelaPrincipal janelaPrincipal; // 🖥️ Referência para a janela principal

  // 🏗️ O construtor inicializa a galeria e a janela principal
  public JanelaRemoverArte(Galeria galeria, JanelaPrincipal janelaPrincipal) {
    this.galeria = galeria; // 🖼️ Recebe a galeria
    this.janelaPrincipal = janelaPrincipal; // 🖥️ Recebe a janela principal
    inicializarUI(); // 🛠️ Inicializa a interface gráfica
  }

  // 🛠️ Método para configurar os componentes da interface gráfica
  private void inicializarUI() {
    setTitle("Remover Arte"); // 📑 Define o título da janela
    setSize(400, 300); // 📏 Define o tamanho da janela
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 🛑 Fecha a janela ao clicar no 'X'

    // 🖼️ Cria uma lista de artes utilizando a galeria
    JList<Arte> listaArtes = new JList<>(galeria.getArtes().toArray(new Arte[0]));
    listaArtes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 🖱️ Permite selecionar apenas uma arte

    // 📜 Adiciona a lista de artes a um JScrollPane para permitir rolagem
    JScrollPane scrollPane = new JScrollPane(listaArtes);
    add(scrollPane); // 📥 Adiciona o scroll ao painel da janela

    // ❌ Cria o botão 'Remover Arte'
    JButton btnRemover = new JButton("Remover Arte");
    btnRemover.addActionListener(e -> { // ⚙️ Ação ao clicar no botão
      Arte arteSelecionada = listaArtes.getSelectedValue(); // 🔍 Obtém a arte selecionada
      if (arteSelecionada != null) { // 🟢 Se uma arte foi selecionada
        galeria.removerArte(arteSelecionada); // 🗑️ Remove a arte da galeria
        JOptionPane.showMessageDialog(this, "Arte removida com sucesso!"); // 📝 Exibe mensagem de sucesso
        janelaPrincipal.mostrarGaleria("Gótica"); // 🖼️ Atualiza a galeria na janela principal
        dispose(); // 🗑️ Fecha a janela de remoção
      } else { // 🛑 Caso nenhuma arte tenha sido selecionada
        JOptionPane.showMessageDialog(this, "Por favor, selecione uma arte para remover.", "Erro", JOptionPane.ERROR_MESSAGE); // ⚠️ Exibe um alerta
      }
    });

    // 🗂️ Cria o painel para adicionar o botão
    JPanel painelBotoes = new JPanel();
    painelBotoes.add(btnRemover); // 📥 Adiciona o botão ao painel
    add(painelBotoes, "South"); // 📥 Coloca o painel de botões na parte inferior da janela
  }
}
```

**Explicação do Código:**

1. **Classe `JanelaRemoverArte`**: Esta classe estende `JFrame`, configurando uma janela gráfica para remover uma arte de uma galeria.
2. **Atributos**:
   - `galeria`: Refere-se à coleção de arte onde as obras estão armazenadas.
   - `janelaPrincipal`: Referência para a janela principal que será atualizada após a remoção da arte.
3. **Construtor**:
   - Recebe a galeria e a janela principal e inicializa a interface gráfica com o método `inicializarUI()`.
4. **Método `inicializarUI()`**:
   - Configura a interface com título, tamanho e comportamento da janela.
   - Cria uma lista (`JList`) de artes da galeria e a coloca em um `JScrollPane` para rolagem.
   - Configura o botão "Remover Arte" com um listener que executa a remoção da arte selecionada e atualiza a galeria na janela principal.
   - Se nenhuma arte for selecionada, exibe um alerta ao usuário.
5. **Botão de Remoção**:
   - O botão tem uma ação associada, que remove a arte da galeria e fecha a janela. Se não houver arte selecionada, exibe uma mensagem de erro.

**Comportamento Visual:**
- A janela possui uma lista de artes, um botão para remover e um painel de botões na parte inferior.
