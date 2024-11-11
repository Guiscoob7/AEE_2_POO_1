import javax.swing.SwingUtilities; // 📦 Importa a classe SwingUtilities para gerenciamento de threads e UI

public class Main { // 🖥️ Classe principal do aplicativo
  public static void main(String[] args) { // 📋 Método principal que inicia a aplicação
    SwingUtilities.invokeLater(() -> { // ⏳ Garante que a criação da janela ocorra na thread de evento da UI
      JanelaPrincipal janela = new JanelaPrincipal(); // 🖼️ Cria uma instância da janela principal
      janela.setVisible(true); // 👀 Torna a janela visível na tela
    });
  }
}
