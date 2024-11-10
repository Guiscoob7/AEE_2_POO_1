```markdown
# Documentação do Código da Janela Principal

Este código representa uma aplicação gráfica em Java utilizando a biblioteca Swing, que exibe uma galeria de artes com categorias de Arte Gótica e Arte Nouveau. A interface gráfica é configurada com painéis, botões e menus, permitindo a interação com o usuário para exibir as artes da galeria e adicionar novas.

## Classes e Pacotes

- `JanelaPrincipal`: Classe principal da interface gráfica, responsável por inicializar e gerenciar os componentes da janela.
- `Galeria`: Classe que contém as artes a serem exibidas na aplicação.
- `Arte`: Classe representando uma arte específica, incluindo suas informações (como título e imagem).

## Importações

```java
import javax.swing.*; // 📦 Importa as bibliotecas necessárias para construir a interface gráfica
import java.awt.*; // 📦 Importa as classes para gerenciamento de layouts e cores
import java.awt.event.ActionEvent; // 📋 Importa o evento para ação de botões
import java.awt.event.ActionListener; // 📋 Importa o listener para capturar as ações de botões
```

## Estrutura da Janela Principal

A `JanelaPrincipal` é a classe que representa a janela onde os componentes da galeria são exibidos.

### Construtor `JanelaPrincipal()`

- Inicializa a galeria com as artes.
- Chama o método `inicializarUI()` para configurar a interface gráfica.

### Método `inicializarUI()`

Configura os componentes principais da interface gráfica:
- Define o título da janela.
- Configura o tamanho da janela.
- Configura o comportamento de fechamento da janela.
- Inicializa os painéis para exibição das artes e categorias.

```java
painelPrincipal = new JPanel(new BorderLayout()); // 🗂️ Cria o painel principal com layout de borda
painelArtes = new JPanel(new GridLayout(0, 3, 10, 10)); // 🖼️ Cria painel para artes com grid de 3 colunas
```

### Método `adicionarMenu()`

Adiciona a barra de menus à janela, com itens como:
- **Arquivo**: Com a opção de "Sair" para fechar a aplicação e "Adicionar Arte" para abrir a janela de inserção de novas artes.

### Método `adicionarCategorias()`

Adiciona os botões para selecionar as categorias de arte:
- **Arte Gótica**
- **Arte Nouveau**

Cada botão, ao ser clicado, exibe as artes da categoria correspondente.

### Método `estilizarBotao(JButton botao)`

Aplica um estilo personalizado para os botões de categorias, incluindo:
- Cor de fundo escura.
- Cor do texto cinza claro.
- Fonte em negrito.

### Método `mostrarGaleria(String categoria)`

Exibe as artes da categoria selecionada (Gótica ou Nouveau) na galeria. A galeria é atualizada com as artes da categoria e pode ser rolada com o uso de um `JScrollPane`.

### Método `criarPainelArte(Arte arte)`

Cria um painel para cada arte, exibindo a imagem e as informações (título) da arte. Este painel é adicionado à galeria.

### Método `main(String[] args)`

Inicia a aplicação criando uma instância da `JanelaPrincipal` e tornando-a visível.

## Estilo Visual

- **Cores**: O fundo dos painéis e botões é predominantemente escuro, criando uma estética sóbria e misteriosa.
- **Fontes**: Utiliza fontes serifadas, com títulos em negrito, para dar um estilo clássico e elegante.
- **Emojis**: Foram utilizados emojis para representar ações e componentes, tornando o código visualmente mais interessante e fácil de entender.

## Exemplo de Uso

1. Ao abrir o programa, a janela principal com a galeria de arte Gótica será exibida.
2. O usuário pode alternar entre as categorias **Arte Gótica** e **Arte Nouveau** clicando nos botões correspondentes.
3. A partir do menu **Arquivo**, o usuário pode adicionar novas artes à galeria.

---

Esse código cria uma interface gráfica interativa para exibir uma galeria de artes, com funcionalidades de navegação por categorias e adição de novas artes à galeria.

## Código

```java
import javax.swing.*; // 📦 Importa as bibliotecas necessárias para construir a interface gráfica
import java.awt.*; // 📦 Importa as classes para gerenciamento de layouts e cores
import java.awt.event.ActionEvent; // 📋 Importa o evento para ação de botões
import java.awt.event.ActionListener; // 📋 Importa o listener para capturar as ações de botões

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 🛑 Define o comportamento ao fechar a janela

        painelPrincipal = new JPanel(new BorderLayout()); // 🗂️ Cria o painel principal com layout de borda
        painelPrincipal.setBackground(new Color(25, 20, 20)); // 🎨 Define a cor de fundo escura
        painelArtes = new JPanel(new GridLayout(0, 3, 10, 10)); // 🖼️ Cria painel para artes com grid de 3 colunas
        painelArtes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 🖼️ Adiciona margens ao painel
        painelArtes.setBackground(new Color(34, 34, 34)); // 🎨 Define a cor de fundo do painel de artes

        adicionarMenu(); // 🛠️ Adiciona o menu de opções
        adicionarCategorias(); // 🛠️ Adiciona os botões de categorias (Arte Gótica, Arte Nouveau)
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

        menuBar.add(menuArquivo); // 📥 Adiciona o menu 'Arquivo' à barra de menus
        setJMenuBar(menuBar); // 📋 Define a barra de menu para a janela
    }

    private void adicionarCategorias() { // 🖼️ Método para adicionar botões de categorias
        JPanel painelCategorias = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 🗂️ Painel de categorias com layout de fluxo
        painelCategorias.setBackground(new Color(25, 20, 20)); // 🎨 Define o fundo escuro para o painel de categorias

        JButton botaoGotico = new JButton("Arte Gótica"); // 🎨 Cria botão para Arte Gótica
        botaoGotico.addActionListener(e -> mostrarGaleria("Gótica")); // ⚙️ Ação ao clicar (mostrar galeria Gótica)
        estilizarBotao(botaoGotico); // 🎨 Estiliza o botão de Arte Gótica

        JButton botaoNouveau = new JButton("Arte Nouveau"); // 🎨 Cria botão para Arte Nouveau
        botaoNouveau.addActionListener(e -> mostrarGaleria("Nouveau")); // ⚙️ Ação ao clicar (mostrar galeria Nouveau)
        estilizarBotao(bot

aoNouveau); // 🎨 Estiliza o botão de Arte Nouveau

        painelCategorias.add(botaoGotico); // 📥 Adiciona o botão de Arte Gótica ao painel
        painelCategorias.add(botaoNouveau); // 📥 Adiciona o botão de Arte Nouveau ao painel
        painelPrincipal.add(painelCategorias, BorderLayout.NORTH); // 📥 Adiciona o painel de categorias à parte superior da janela
    }

    private void estilizarBotao(JButton botao) { // 🎨 Método para estilizar botões
        botao.setBackground(new Color(50, 50, 50)); // 🎨 Cor de fundo escura
        botao.setForeground(Color.LIGHT_GRAY); // 🎨 Cor do texto clara
        botao.setFont(new Font("Serif", Font.BOLD, 14)); // 🖋️ Fonte em negrito e tamanho 14
    }

    private void mostrarGaleria(String categoria) { // 🖼️ Método para mostrar a galeria de arte
        painelArtes.removeAll(); // ❌ Remove todos os componentes da galeria anterior
        galeria.getArtes(categoria).forEach(arte -> painelArtes.add(criarPainelArte(arte))); // 🖼️ Adiciona as artes da categoria à galeria
        painelPrincipal.add(new JScrollPane(painelArtes), BorderLayout.CENTER); // 📥 Adiciona a galeria ao painel principal
        revalidate(); // 🔄 Atualiza a interface
        repaint(); // 🔄 Repinta a interface
    }

    private JPanel criarPainelArte(Arte arte) { // 🖼️ Método para criar o painel de uma arte
        JPanel painelArte = new JPanel(); // 🖼️ Cria um painel para a arte
        painelArte.setLayout(new BorderLayout()); // 🗂️ Define o layout para o painel da arte
        painelArte.setBackground(new Color(40, 40, 40)); // 🎨 Cor de fundo do painel da arte

        JLabel imagem = new JLabel(new ImageIcon(arte.getImagem())); // 🖼️ Cria o JLabel para exibir a imagem
        painelArte.add(imagem, BorderLayout.CENTER); // 📥 Adiciona a imagem ao painel de arte

        JLabel titulo = new JLabel(arte.getTitulo(), SwingConstants.CENTER); // 🏷️ Cria o JLabel para o título da arte
        titulo.setForeground(Color.WHITE); // 🎨 Define a cor do texto como branco
        painelArte.add(titulo, BorderLayout.SOUTH); // 📥 Adiciona o título abaixo da imagem

        return painelArte; // 🖼️ Retorna o painel da arte
    }

    public static void main(String[] args) { // 🏁 Método principal para iniciar a aplicação
        SwingUtilities.invokeLater(() -> { // 🏃 Executa a interface gráfica na thread de eventos do Swing
            JanelaPrincipal janela = new JanelaPrincipal(); // 🖥️ Cria a janela principal
            janela.setVisible(true); // 👀 Torna a janela visível
        });
    }
}
```
