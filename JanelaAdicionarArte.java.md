```markdown
# Classe `JanelaAdicionarArte` 🖼️

A classe `JanelaAdicionarArte` cria uma janela para adicionar novas obras de arte à galeria. A interface permite ao usuário preencher informações sobre a obra, como título, artista, descrição, caminho da imagem e categoria. A classe também permite procurar um arquivo de imagem para associar à obra e adicionar a arte à galeria.

## Atributos

- `campoTitulo` (JTextField) 🏷️: Campo de entrada para o título da obra de arte.
- `campoArtista` (JTextField) 👩‍🎨: Campo de entrada para o nome do artista.
- `campoDescricao` (JTextField) 📝: Campo de entrada para a descrição da obra.
- `campoImagemCaminho` (JTextField) 🖼️: Campo de entrada para o caminho da imagem associada à obra.
- `campoCategoria` (JTextField) 📚: Campo de entrada para a categoria da obra (ex: Gótica, Art Nouveau).
- `galeria` (Galeria) 🎨: Objeto da classe `Galeria` responsável por gerenciar as obras de arte.
- `janelaPrincipal` (JanelaPrincipal) 🏠: Objeto da classe `JanelaPrincipal` para atualizar a visualização após adicionar uma arte.

## Construtor

### `public JanelaAdicionarArte(Galeria galeria, JanelaPrincipal janelaPrincipal)`

Constrói a janela para adicionar uma nova arte. Inicializa a interface gráfica e configura o título e o tamanho da janela.

- **Parâmetros**:
  - `galeria`: O objeto da classe `Galeria` onde a obra será adicionada.
  - `janelaPrincipal`: O objeto da classe `JanelaPrincipal` para atualizar a visualização da galeria.

### Exemplo de uso:

```java
JanelaAdicionarArte janela = new JanelaAdicionarArte(minhaGaleria, minhaJanelaPrincipal);
janela.setVisible(true);
```

## Métodos

### `private void inicializarUI()`

Método responsável por configurar a interface gráfica da janela. Cria campos de entrada e botões, e os organiza no layout.

- **Ações**:
  - Adiciona labels e campos de texto para título, artista, descrição, caminho da imagem e categoria.
  - Adiciona um botão para procurar uma imagem e outro para adicionar a obra à galeria.

### `private void abrirFileChooser()`

Método que abre um seletor de arquivos para permitir ao usuário selecionar uma imagem para associar à obra de arte.

- **Ação**: Quando o botão "Procurar" é clicado, o seletor de arquivos é exibido, permitindo que o usuário selecione um arquivo de imagem.

### `private void adicionarArte()`

Método responsável por coletar os valores dos campos de entrada e adicionar a nova obra de arte à galeria. 

- **Ação**:
  - Verifica se os campos obrigatórios (título, artista e categoria) estão preenchidos antes de adicionar a obra.
  - Caso a arte seja adicionada com sucesso, a galeria é atualizada e uma mensagem de sucesso é exibida.

### Exemplo de uso:

```java
// Criação da janela para adicionar arte
JanelaAdicionarArte janela = new JanelaAdicionarArte(minhaGaleria, minhaJanelaPrincipal);

// Tornar a janela visível
janela.setVisible(true);
```

## Código da Classe `JanelaAdicionarArte`

```java
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class JanelaAdicionarArte extends JFrame {
    // 🎨 Campos de entrada de dados para adicionar uma nova obra de arte
    private JTextField campoTitulo;
    private JTextField campoArtista;
    private JTextField campoDescricao;
    private JTextField campoImagemCaminho;
    private JTextField campoCategoria;

    // 🖼️ Referências à galeria e à janela principal para atualização
    private Galeria galeria;
    private JanelaPrincipal janelaPrincipal;

    // 🖼️ Construtor para inicializar a janela de adicionar arte
    public JanelaAdicionarArte(Galeria galeria, JanelaPrincipal janelaPrincipal) {
        this.galeria = galeria;
        this.janelaPrincipal = janelaPrincipal;

        setTitle("Adicionar Nova Arte");       // 🖌️ Define o título da janela
        setSize(400, 350);                     // 📏 Define o tamanho da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 🚪 Fecha a janela atual sem fechar o programa
        inicializarUI();                       // 🎨 Inicializa a interface do usuário
    }

    // 🎨 Inicializa os componentes gráficos e organiza o layout da janela
    private void inicializarUI() {
        JPanel painelForm = new JPanel(new GridLayout(7, 2, 5, 5)); // 🌐 Layout de grade para os campos do formulário
        painelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 📏 Margem interna do painel

        // 🎨 Campos de texto para entrada dos detalhes da arte
        campoTitulo = new JTextField();
        campoArtista = new JTextField();
        campoDescricao = new JTextField();
        campoImagemCaminho = new JTextField();
        campoCategoria = new JTextField();

        // 🎫 Labels e campos para cada detalhe da arte
        painelForm.add(new JLabel("Título:"));
        painelForm.add(campoTitulo);
        painelForm.add(new JLabel("Artista:"));
        painelForm.add(campoArtista);
        painelForm.add(new JLabel("Descrição:"));
        painelForm.add(campoDescricao);
        painelForm.add(new JLabel("Caminho da Imagem:"));
        painelForm.add(campoImagemCaminho);

        // 📂 Botão para procurar imagem no sistema de arquivos
        JButton botaoProcurarImagem = new JButton("Procurar...");
        botaoProcurarImagem.addActionListener(e -> abrirFileChooser()); // 📂 Ação ao clicar no botão "Procurar"
        painelForm.add(botaoProcurarImagem);

        // 🎭 Campo de texto para a categoria da arte
        painelForm.add(new JLabel("Categoria:"));
        painelForm.add(campoCategoria);

        // ➕ Botão para adicionar a arte
        JButton botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.addActionListener(e -> adicionarArte()); // 🎨 Ação ao clicar no botão "Adicionar"
        painelForm.add(botaoAdicionar);

        add(painelForm); // Adiciona o painel à janela
    }

    // 📂 Método para abrir o seletor de arquivos e definir o caminho da imagem
    private void abrirFileChooser() {
        JFileChooser fileChooser = new JFileChooser(); // 📂 Inicializa o seletor de arquivos
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // 📂 Apenas arquivos, sem diretórios
        int resultado = fileChooser.showOpenDialog(this); // 🖼️ Exibe o seletor de arquivos

        // ✅ Caso um arquivo seja selecionado, define o caminho no campo correspondente
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();
            campoImagemCaminho.setText(arquivoSelecionado.getAbsolutePath()); // 📂 Define o caminho do arquivo selecionado
        }
    }

    // 🎨 Método para criar e adicionar uma nova obra de arte à galeria
    private void adicionarArte() {
        // ✏️ Coleta os valores dos campos de entrada
        String titulo = campoTitulo.getText();
        String artista = campoArtista.getText();
        String descricao = campoDescricao.getText();
        String imagemCaminho = campoImagemCaminho.getText();
        String categoria = campoCategoria.getText();

        // ✅ Verifica se os campos obrigatórios foram preenchidos antes de adicionar
        if (!titulo.isEmpty() && !artista.isEmpty() && !categoria.isEmpty()) {
            Arte novaArte = new Arte(titulo, artista, descricao, imagemCaminho, categoria); // 🖼️ Cria nova arte
            galeria.adicionarArte(novaArte); // 🎨 Adiciona a arte na galeria
            janelaPrincipal.mostrarGaleria(categoria); // 🔄 Atualiza a galeria na interface principal
            JOptionPane.showMessageDialog(this, "Arte adicionada com sucesso!"); // 🎉 Mensagem de sucesso
            dispose(); // 🚪 Fecha a janela após adicionar a arte
        } else {
            // ⚠️ Mensagem de erro caso algum campo obrigatório esteja vazio
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
```
