```markdown
# Documentação da Classe `JanelaAdicionarArte` 🖥️

A classe `JanelaAdicionarArte` representa a janela responsável por adicionar uma nova arte à galeria, permitindo ao usuário inserir informações como título, artista, descrição, caminho da imagem e categoria. Abaixo está uma descrição detalhada de cada parte do código.

## Importações 📦

```java
import javax.swing.*; // 📦 Importa as bibliotecas necessárias para criar a interface gráfica
import java.awt.*; // 📦 Importa classes para gerenciamento de layout e cores
import java.io.*; // 📂 Importa as classes para trabalhar com arquivos
import java.util.List; // 📦 Importa a lista para armazenar as artes
import java.util.ArrayList; // 📦 Importa a classe ArrayList
```

## Atributos da Classe 🖼️

- **campoTitulo**: `JTextField` para o título da arte ✍️
- **campoArtista**: `JTextField` para o nome do artista ✍️
- **campoDescricao**: `JTextField` para a descrição da arte ✍️
- **campoImagemCaminho**: `JTextField` para o caminho da imagem 📂
- **campoCategoria**: `JComboBox<String>` para selecionar a categoria da arte 📦
- **galeria**: Instância da classe `Galeria` 🖼️
- **janelaPrincipal**: Referência à janela principal 🖥️
- **listaArtes**: `List<Arte>` para armazenar as artes 📂

## Construtor da Classe 🏗️

O construtor inicializa os componentes da janela e configura suas propriedades.

```java
public JanelaAdicionarArte(Galeria galeria, JanelaPrincipal janelaPrincipal) { // 🏗️ Construtor da janela de adicionar arte
    this.galeria = galeria; // 📂 Inicializa a galeria
    this.janelaPrincipal = janelaPrincipal; // 🖥️ Inicializa a janela principal
    this.listaArtes = new ArrayList<>(); // 🖼️ Inicializa a lista de artes

    setTitle("Adicionar Nova Arte"); // 📑 Define o título da janela
    setSize(400, 350); // 📏 Define o tamanho da janela
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 🚪 Fecha a janela sem encerrar o aplicativo
    inicializarUI(); // 🛠️ Chama o método para configurar a interface gráfica
}
```

## Método `inicializarUI()` 🛠️

Este método configura a interface gráfica da janela, incluindo os campos de entrada, botões e layout.

```java
private void inicializarUI() { // 🛠️ Método para configurar os componentes da interface gráfica
    JPanel painelForm = new JPanel(new GridLayout(7, 2, 5, 5)); // 🗂️ Painel com grid para organizar os campos
    painelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 🎨 Define as margens internas do painel

    campoTitulo = new JTextField(); // ✍️ Campo de texto para o título da arte
    campoArtista = new JTextField(); // ✍️ Campo de texto para o artista
    campoDescricao = new JTextField(); // ✍️ Campo de texto para a descrição da arte
    campoImagemCaminho = new JTextField(); // 📂 Campo de texto para o caminho da imagem

    campoCategoria = new JComboBox<>(new String[] {"Gótica", "Nouveau"}); // 🔽 Opções de categoria

    // 🏷️ Adiciona rótulos e campos ao painel
    painelForm.add(new JLabel("Título:"));
    painelForm.add(campoTitulo);
    painelForm.add(new JLabel("Artista:"));
    painelForm.add(campoArtista);
    painelForm.add(new JLabel("Descrição:"));
    painelForm.add(campoDescricao);
    painelForm.add(new JLabel("Caminho da Imagem:"));
    painelForm.add(campoImagemCaminho);

    // 🔍 Adiciona o botão "Procurar..." para buscar a imagem
    JButton botaoProcurarImagem = new JButton("Procurar...");
    botaoProcurarImagem.addActionListener(e -> abrirFileChooser()); // ⚙️ Abre o seletor de arquivos
    painelForm.add(botaoProcurarImagem);

    painelForm.add(new JLabel("Categoria:")); // 🏷️ Adiciona rótulo "Categoria" ao painel
    painelForm.add(campoCategoria); // 📥 Adiciona o ComboBox de categoria ao painel

    // ➕ Adiciona o botão "Adicionar" para adicionar a arte
    JButton botaoAdicionar = new JButton("Adicionar");
    botaoAdicionar.addActionListener(e -> adicionarArte()); // ⚙️ Ação para adicionar a arte
    painelForm.add(botaoAdicionar);

    add(painelForm); // 📥 Adiciona o painel ao corpo da janela
}
```

## Método `abrirFileChooser()` 🔄

Este método abre um seletor de arquivos para o usuário escolher a imagem da arte.

```java
private void abrirFileChooser() { // 🔄 Método para abrir o seletor de arquivos
    JFileChooser fileChooser = new JFileChooser(); // 🗂️ Cria o seletor de arquivos
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // 📂 Permite selecionar apenas arquivos
    int resultado = fileChooser.showOpenDialog(this); // ⚙️ Exibe a caixa de diálogo para abrir um arquivo
    if (resultado == JFileChooser.APPROVE_OPTION) { // ✅ Verifica se o usuário aprovou a seleção
        File arquivoSelecionado = fileChooser.getSelectedFile(); // 📝 Obtém o arquivo selecionado
        String diretorioBase = new File("").getAbsolutePath(); // 📂 Obtém o diretório base
        String caminhoRelativo = arquivoSelecionado.getAbsolutePath().substring(diretorioBase.length() + 1); // Calcula o caminho relativo
        campoImagemCaminho.setText(caminhoRelativo); // 🖼️ Preenche o campo com o caminho relativo
    }
}
```

## Método `adicionarArte()` ➕

Este método é responsável por adicionar a nova arte à galeria e salvar os dados em um arquivo.

```java
private void adicionarArte() { // ➕ Método para adicionar uma nova arte
    String titulo = campoTitulo.getText(); // 📝 Obtém o título da arte
    String artista = campoArtista.getText(); // 📝 Obtém o nome do artista
    String descricao = campoDescricao.getText(); // 📝 Obtém a descrição da arte
    String imagemCaminho = campoImagemCaminho.getText(); // 📂 Obtém o caminho da imagem
    String categoria = (String) campoCategoria.getSelectedItem(); // 📝 Obtém a categoria escolhida

    if (!titulo.isEmpty() && !artista.isEmpty() && categoria != null) { // ✅ Verifica se os campos obrigatórios estão preenchidos
        Arte novaArte = new Arte(titulo, artista, descricao, imagemCaminho, categoria); // 🖼️ Cria um novo objeto Arte
        listaArtes.add(novaArte); // 📥 Adiciona a nova arte à lista de artes
        try {
            salvarArtesEmArquivo(listaArtes); // 💾 Salva a lista de artes em um arquivo
            galeria.adicionarArte(novaArte); // 📥 Adiciona a nova arte à galeria
            janelaPrincipal.mostrarGaleria(categoria); // 🖼️ Atualiza a galeria na janela principal
            JOptionPane.showMessageDialog(this, "Arte adicionada com sucesso!"); // 🎉 Exibe mensagem de sucesso
        } catch (IOException e) {
            dispose(); // 🚪 Fecha a janela de adicionar arte
        }
    } else {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE); // ⚠️ Exibe mensagem de erro
    }
}
```

## Método `salvarArtesEmArquivo()` 💾

Este método salva a lista de artes em um arquivo binário.

```java
private void salvarArtesEmArquivo(List<Arte> artes) throws IOException { // 💾 Método para salvar os dados das artes em um arquivo binário
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("galeria.ser"))) { // 📂 Abre o arquivo para escrita binária
        oos.writeObject(artes); // 📝 Escreve a lista de objetos Arte no arquivo
        System.out.println("Artes salvas com sucesso."); // ✅ Mensagem de sucesso
    } catch (IOException e) { // ⚠️ Captura qualquer erro de escrita no arquivo
        JOptionPane.showMessageDialog(this, "Erro ao salvar as artes.", "Erro", JOptionPane.ERROR_MESSAGE); // Exibe mensagem de erro
        e.printStackTrace(); // 🧰 Imprime a stack trace no console
        throw e; // Relança a exceção IOException
    }
}
```
