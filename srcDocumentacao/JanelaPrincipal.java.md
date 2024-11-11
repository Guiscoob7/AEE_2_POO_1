```markdown
# Documentação da Janela Principal do Sistema de Galeria

Este código define a interface gráfica para um sistema de exibição de uma galeria de arte com categorias específicas de **Arte Gótica** e **Arte Nouveau**. Abaixo, você encontra a descrição de cada parte do código e seu funcionamento.

---

### Pacotes Importados

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
```

Esses pacotes são importados para a criação da interface gráfica (Swing), para gerenciar layouts e eventos, e para tratar interações do usuário, como cliques de botões.

---

### Classe `JanelaPrincipal`

A classe `JanelaPrincipal` herda de `JFrame` e é responsável pela criação da janela onde o conteúdo será exibido.

#### Atributos:

```java
private Galeria galeria;    // 🎨 Objeto que contém as artes da galeria
private JPanel painelPrincipal; // 🖼️ Painel principal que organiza os componentes
private JPanel painelArtes;    // 🖼️ Painel específico para exibir as artes
```

- **`galeria`**: Um objeto que contém as artes a serem exibidas.
- **`painelPrincipal`**: O painel principal onde os outros componentes serão adicionados.
- **`painelArtes`**: O painel que exibe as artes selecionadas.

#### Construtor:

```java
public JanelaPrincipal() {
    galeria = new Galeria(); // 🖼️ Inicializa a galeria de artes
    inicializarUI();         // 🖥️ Chama o método para configurar a interface
}
```

O construtor inicializa o objeto `galeria` e chama o método `inicializarUI()` para configurar a interface gráfica.

---

### Método `inicializarUI`

```java
private void inicializarUI() {
    setTitle("Galeria de Arte");        // 🎨 Define o título da janela
    setSize(800, 600);                  // 🖥️ Define o tamanho da janela
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ❌ Define a operação de fechamento
    setLocationRelativeTo(null);        // 📍 Centraliza a janela na tela

    painelPrincipal = new JPanel();     // 🖼️ Cria o painel principal
    painelPrincipal.setLayout(new BorderLayout()); // 📐 Define o layout do painel principal
    
    adicionarMenu();                    // 🍽️ Adiciona o menu
    adicionarCategorias();              // 🖼️ Adiciona as categorias

    add(painelPrincipal);               // ➕ Adiciona o painel principal à janela
    setVisible(true);                   // 👀 Torna a janela visível
}
```

Este método configura a interface gráfica, define o título da janela, o tamanho e o comportamento de fechamento. Ele também chama os métodos de adição do menu e das categorias.

---

### Método `adicionarMenu`

```java
private void adicionarMenu() {
    JMenuBar menuBar = new JMenuBar();  // 🍴 Cria a barra de menu
    JMenu menuArquivo = new JMenu("Arquivo"); // 📂 Cria o menu de "Arquivo"
    JMenuItem itemSair = new JMenuItem("Sair"); // ❌ Cria o item de "Sair"
    itemSair.addActionListener(e -> System.exit(0));  // 🚪 Adiciona ação para fechar a aplicação
    
    JMenuItem itemAdicionarArte = new JMenuItem("Adicionar Arte"); // ➕ Cria o item para adicionar arte
    itemAdicionarArte.addActionListener(e -> new JanelaAdicionarArte(galeria)); // 🖼️ Abre janela para adicionar arte

    JMenuItem itemRemoverArte = new JMenuItem("Remover Arte"); // 🗑️ Cria o item para remover arte
    itemRemoverArte.addActionListener(e -> new JanelaRemoverArte(galeria)); // 🖼️ Abre janela para remover arte

    menuArquivo.add(itemSair);         // 📝 Adiciona "Sair" ao menu
    menuArquivo.add(itemAdicionarArte); // ➕ Adiciona "Adicionar Arte" ao menu
    menuArquivo.add(itemRemoverArte);   // 🗑️ Adiciona "Remover Arte" ao menu
    menuBar.add(menuArquivo);           // 🍽️ Adiciona o menu ao menuBar
    
    setJMenuBar(menuBar);              // 🖥️ Define a barra de menu para a janela
}
```

Este método cria e adiciona a barra de menu com as opções de "Sair", "Adicionar Arte" e "Remover Arte", conectando cada item a sua ação correspondente.

---

### Método `adicionarCategorias`

```java
private void adicionarCategorias() {
    JTabbedPane abas = new JTabbedPane(); // 📚 Cria as abas para as categorias
    JPanel painelGothic = new JPanel();   // 🖼️ Cria o painel para Arte Gótica
    painelGothic.add(new JLabel("Arte Gótica: Obras relacionadas ao movimento gótico")); // 🖼️ Descrição da Arte Gótica
    abas.addTab("Arte Gótica", painelGothic);  // 📑 Adiciona a aba de Arte Gótica
    
    JPanel painelNouveau = new JPanel(); // 🖼️ Cria o painel para Arte Nouveau
    painelNouveau.add(new JLabel("Arte Nouveau: Obras inspiradas na natureza e linhas curvas")); // 🖼️ Descrição da Arte Nouveau
    abas.addTab("Arte Nouveau", painelNouveau); // 📑 Adiciona a aba de Arte Nouveau

    painelPrincipal.add(abas, BorderLayout.CENTER); // ➕ Adiciona as abas no painel principal
}
```

Este método cria e adiciona as abas de categorias "Arte Gótica" e "Arte Nouveau", com uma breve descrição de cada categoria.

---

### Método `mostrarGaleria`

```java
public void mostrarGaleria(String categoria) {
    painelArtes.removeAll();  // 🧹 Limpa o painel de artes antes de mostrar novas
    List<Arte> artes = galeria.obterArtesPorCategoria(categoria); // 🖼️ Obtém as artes da categoria selecionada
    
    for (Arte arte : artes) {  // 🔄 Itera sobre as artes da categoria
        painelArtes.add(new JLabel(arte.getImagem()));  // 🖼️ Adiciona a arte ao painel
    }
    painelArtes.revalidate();  // 🔄 Revalida o painel para atualização
    painelArtes.repaint();     // 🎨 Redesenha o painel com as novas artes
}
```

Este método exibe as artes da categoria selecionada, atualizando o painel de exibição de arte.

## Componentes da Interface

### Menu

A barra de menu possui as seguintes opções:

- **Arquivo**:
  - **Sair**: Fecha a aplicação.
  - **Adicionar Arte**: Abre a janela para adicionar uma nova arte à galeria.
  - **Remover Arte**: Abre a janela para remover uma arte existente da galeria.

### Categorias

O sistema possui duas categorias principais de arte que podem ser selecionadas:

- **Arte Gótica**: Mostra as obras do movimento artístico Gótico, com foco na verticalidade e nos vitrais das igrejas.
- **Arte Nouveau**: Mostra as obras do movimento artístico Art Nouveau, conhecido pelas linhas curvas inspiradas na natureza.

### Painel de Artes

As artes são exibidas em um **`JPanel`** usando um **`GridLayout`** para organizar as imagens em um layout de grade de 3 colunas.

---

## Como Adicionar e Remover Artes

A funcionalidade de adicionar e remover artes está disponível no menu:

- **Adicionar Arte**: Abre uma nova janela onde o usuário pode inserir uma nova obra de arte na galeria.
- **Remover Arte**: Abre uma janela onde o usuário pode remover uma arte existente da galeria.

Esses processos são gerenciados pelas classes `JanelaAdicionarArte` e `JanelaRemoverArte`, que interagem com o objeto `galeria`.

---

## Exemplo de Uso

Para usar a galeria, basta executar o programa. A janela principal será aberta com as categorias "Arte Gótica" e "Arte Nouveau". O usuário pode alternar entre as categorias e visualizar as artes relacionadas a cada movimento artístico.

Se quiser adicionar ou remover artes, basta usar as opções no menu para interagir com a galeria.

---

## Conclusão

Esta aplicação oferece uma interface gráfica simples e eficiente para a exibição de artes, com categorias bem definidas e um menu funcional para manipulação da galeria. O uso de **Swing** facilita a criação da interface gráfica, enquanto a estrutura do código permite fácil expansão e personalização.
```

Comentários com emojis foram adicionados ao código para facilitar a compreensão visual e tornar o código mais interativo e divertido.
