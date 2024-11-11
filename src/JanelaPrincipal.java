import javax.swing.*; // 📦 Importa as bibliotecas necessárias para construir a interface gráfica
import java.awt.*; // 📦 Importa as classes para gerenciamento de layouts e cores
import java.awt.event.ActionEvent; // 📋 Importa o evento para ação de botões
import java.awt.event.ActionListener; // 📋 Importa o listener para capturar as ações de botões
import java.awt.event.MouseAdapter; // 📋 Importa o adapter para capturar eventos de mouse
import java.awt.event.MouseEvent; // 📋 Importa o evento de mouse
import java.awt.event.MouseWheelEvent; // 📦 Importa a classe para o evento de rolagem do mouse
import java.awt.event.MouseWheelListener; // 📦 Importa a classe para o listener de rolagem do mouse

public class JanelaPrincipal extends JFrame { // 🖥️ Classe que representa a janela principal do programa
  private Galeria galeria; // 🖼️ Instância da galeria de artes
  private JPanel painelPrincipal; // 🗂️ Painel principal que contém todos os elementos
  private JPanel painelArtes; // 🖼️ Painel onde as artes serão exibidas

  public JanelaPrincipal() { // 🏗️ Construtor da janela principal
    galeria = new Galeria(); // 🖼️ Inicializa a galeria com as artes
    inicializarUI(); // 🛠️ Chama o método para configurar a interface gráfica
  }

  private void inicializarUI() { // 🛠️ Método para configurar a interface gráfica
    setTitle("Galeria Gótica & Nouveau"); // 📑 Define o título da janela
    setSize(800, 600); // 📏 Define o tamanho da janela
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // 🛑 Define para não fechar automaticamente

    // 🔒 Adiciona o listener para confirmação de saída
    addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosing(java.awt.event.WindowEvent e) { // 📥 Evento de fechamento da janela
        int resposta = JOptionPane.showConfirmDialog(
          null,
          "Tem certeza que deseja sair?", // ❓ Mensagem de confirmação
          "Confirmação de Saída", // 📑 Título da caixa de diálogo
          JOptionPane.YES_NO_OPTION // 🗂️ Opções "Sim" e "Não"
        );

        if (resposta == JOptionPane.YES_OPTION) { // ✔️ Se o usuário confirmar, fecha o programa
          dispose(); // 🗑️ Libera recursos e fecha a janela
          System.exit(0); // 🛑 Encerra o programa
        }
      }
    });

    painelPrincipal = new JPanel(new BorderLayout()); // 🗂️ Cria o painel principal com layout de borda
    painelPrincipal.setBackground(new Color(25, 20, 20)); // 🎨 Define a cor de fundo escura
    painelArtes = new JPanel(new GridLayout(0, 3, 10, 10)); // 🖼️ Cria painel para artes com grid de 3 colunas
    painelArtes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 🖼️ Adiciona margens ao painel
    painelArtes.setBackground(new Color(34, 34, 34)); // 🎨 Define a cor de fundo do painel de artes

    adicionarMenu(); // 🛠️ Adiciona o menu de opções
    adicionarCategorias(); // 🛠️ Adiciona as abas para categorias (Arte Gótica, Arte Nouveau)
    mostrarGaleria("Gótica"); // 🖼️ Exibe a galeria da categoria Gótica inicialmente

    add(painelPrincipal); // 📥 Adiciona o painel principal à janela
  }

  private void adicionarMenu() { // 🍽️ Método para adicionar o menu
    JMenuBar menuBar = new JMenuBar(); // 🍴 Cria a barra de menu
    menuBar.setBackground(new Color(50, 50, 50)); // 🎨 Define a cor de fundo da barra de menu

    JMenu menuArquivo = new JMenu("Arquivo"); // 📂 Cria o menu 'Arquivo'
    menuArquivo.setForeground(Color.LIGHT_GRAY); // 🎨 Define a cor do texto do menu

    JMenuItem itemSair = new JMenuItem("Sair"); // ❌ Cria o item de menu 'Sair'
    itemSair.addActionListener(e -> System.exit(0)); // ⚙️ Adiciona ação para fechar o aplicativo
    menuArquivo.add(itemSair); // 📥 Adiciona o item ao menu 'Arquivo'

    JMenuItem itemAdicionarArte = new JMenuItem("Adicionar Arte"); // ➕ Cria o item 'Adicionar Arte'
    itemAdicionarArte.addActionListener(e -> { // ⚙️ Ação de adicionar arte
      JanelaAdicionarArte janelaAdicionar = new JanelaAdicionarArte(galeria, this); // 🖼️ Abre a janela para adicionar arte
      janelaAdicionar.setVisible(true); // 👀 Torna a janela de adicionar arte visível
    });
    menuArquivo.add(itemAdicionarArte); // 📥 Adiciona o item ao menu 'Arquivo'

    // Adicionando o item para remover arte
    JMenuItem itemRemoverArte = new JMenuItem("Remover Arte"); // ❌ Cria o item 'Remover Arte'
    itemRemoverArte.addActionListener(e -> { // ⚙️ Ação de remover arte
      JanelaRemoverArte janelaRemover = new JanelaRemoverArte(galeria, this); // 🖼️ Abre a janela para remover arte
      janelaRemover.setVisible(true); // 👀 Torna a janela de remover arte visível
    });
    menuArquivo.add(itemRemoverArte); // 📥 Adiciona o item ao menu 'Arquivo'

    menuBar.add(menuArquivo); // 📥 Adiciona o menu 'Arquivo' à barra de menus
    setJMenuBar(menuBar); // 📋 Define a barra de menu para a janela
  }

  private void adicionarCategorias() { // 🖼️ Método para adicionar abas de categorias
    JTabbedPane tabbedPane = new JTabbedPane(); // 📑 Cria o JTabbedPane para as categorias
    tabbedPane.setBackground(new Color(0, 206, 209)); // 🎨 Define a cor de fundo das abas

    // Criando o painel para Arte Gótica
    JPanel painelGotico = new JPanel();
    painelGotico.setLayout(new BorderLayout()); // 📏 Define o layout do painel
    painelGotico.setBackground(new Color(34, 34, 34)); // 🎨 Define o fundo escuro para a aba

    // Texto explicativo para a Arte Gótica
    String textoGotico = "<html><div style='padding:10px; font-size:14px; color:white;'>"
        + "<strong>Arte Gótica</strong><br>"
        + "A arte gótica surgiu na França no século XII e durou até o final do século XV. Caracteriza-se por sua verticalidade, "
        + "com grandes vitrais, arcos ogivais e uma busca por iluminar e elevar espiritualmente o espectador. A arquitetura gótica "
        + "é especialmente famosa por suas catedrais e igrejas com vitrais coloridos, que retratam cenas religiosas."
        + "</div></html>";
    JLabel labelGotico = new JLabel(textoGotico);
    painelGotico.add(labelGotico, BorderLayout.CENTER); // Adiciona o texto explicativo à aba de Arte Gótica

    tabbedPane.addTab("Arte Gótica", painelGotico); // 📥 Adiciona a aba "Arte Gótica"

    // Criando o painel para Arte Nouveau
    JPanel painelNouveau = new JPanel();
    painelNouveau.setLayout(new BorderLayout()); // 📏 Define o layout do painel
    painelNouveau.setBackground(new Color(34, 34, 34)); // 🎨 Define o fundo escuro para a aba

    // Texto explicativo para a Arte Nouveau
    String textoNouveau = "<html><div style='padding:10px; font-size:14px; color:white;'>"
        + "<strong>Arte Nouveau</strong><br>"
        + "A Arte Nouveau, ou Art Nouveau, foi um movimento artístico que floresceu na Europa no final do século XIX e início do século XX. "
        + "É conhecida pelo uso de linhas curvas e formas inspiradas na natureza, como flores, folhas e vinhas. A Art Nouveau esteve presente em "
        + "diversas manifestações artísticas, como arquitetura, mobiliário, pintura e design de vidro. Esse estilo buscava romper com os "
        + "padrões tradicionais da arte acadêmica da época."
        + "</div></html>";
    JLabel labelNouveau = new JLabel(textoNouveau);
    painelNouveau.add(labelNouveau, BorderLayout.CENTER); // Adiciona o texto explicativo à aba de Arte Nouveau

    tabbedPane.addTab("Arte Nouveau", painelNouveau); // 📥 Adiciona a aba "Arte Nouveau"

    // Adiciona listener para mudança de aba
    tabbedPane.addChangeListener(e -> { 
      int selectedIndex = tabbedPane.getSelectedIndex(); // 📏 Obtém o índice da aba selecionada
      if (selectedIndex == 0) { // Se a aba de arte gótica for selecionada
        mostrarGaleria("Gótica");
      } else { // Se a aba de arte Nouveau for selecionada
        mostrarGaleria("Nouveau");
      }
    });

    painelPrincipal.add(tabbedPane, BorderLayout.NORTH); // 📥 Adiciona o tabbedPane ao painel principal
  }

  public void mostrarGaleria(String categoria) { // 🖼️ Método para exibir as artes da categoria selecionada
    painelArtes.removeAll(); // 🧹 Limpa o painel de artes

    for (Arte arte : galeria.getArtes(categoria)) { // 🖼️ Itera sobre as artes da categoria
      JLabel arteLabel = new JLabel(arte.getNome(), new ImageIcon(arte.getImagem()), JLabel.CENTER); // 🎨 Cria o rótulo para a arte
      arteLabel.setForeground(Color.WHITE); // 🎨 Define a cor do texto como branco
      painelArtes.add(arteLabel); // 📥 Adiciona a arte ao painel de artes
    }

    painelPrincipal.add(painelArtes, BorderLayout.CENTER); // 📥 Adiciona o painel de artes ao painel principal
    painelPrincipal.revalidate(); // 🔄 Atualiza a interface gráfica
    painelPrincipal.repaint(); // 🔄 Repaint para garantir que tudo foi redesenhado corretamente
  }

  public static void main(String[] args) { // 🎮 Método main para rodar a aplicação
    SwingUtilities.invokeLater(() -> { // 🖥️ Executa a aplicação na thread de eventos do Swing
      JanelaPrincipal janela = new JanelaPrincipal(); // 🖼️ Cria a instância da janela
      janela.setVisible(true); // 👀 Torna a janela visível
    });
  }
}
