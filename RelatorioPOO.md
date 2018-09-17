# projeto-poo-teameclipse
projeto-poo-teameclipse created by GitHub Classroom
**UFPB – Centro de Ciências Aplicadas e Educação**

**Disciplina:** Programação Orientada à Objetos(POO)

**Professor:** Fábio Morais

**Alunos:**

        Ana Paula de Lima Borges Silva – [ana.paula@dce.ufpb.br](mailto:ana.paula@dce.ufpb.br)

        Ronaldo de Holanda Neves Filho – [Ronaldo.holanda@dce.ufpb.br](mailto:Ronaldo.holanda@dce.ufpb.br)



**UserStory5 (Sorte ou Revés):**

**       ** Primeiramente, optamos por criar um pacote para trabalhar só com as cartas porque ajuda na organização. Após a criação do pacote escolhemos elaborar uma classe chamada &quot;Carta&quot; que tem como atributos:

        -Uma String descrição;

        -Um int valor;

        -Um String tipo;

Os métodos dessa classe são descricoesDasCartas() que é um ArrayList responsável pelas descrições das cartas, e também temos valoresDasCartas() que é um ArrayList responsável pelos respectivos valores das cartas. Criamos uma classe chamada &quot;Baralho&quot; que possui como atributos:

-Um Carta do tipo carta;

-Um Stack de Baralho;

Nos métodos dela foi que criamos os tipos das cartas que eram 7: receba especial, prisão, inicio, jogue dados, soma dados, receba e pague. Foi elaborado um método que é um Stack &quot;criarBaralho&quot; para de fato criar o baralho de cartas do sorte ou revés, método esse que já embaralha as cartas com o uso do _shuffle._ Criamos um método para puxar a carta e outro para recolocar na pilha.

Já na classe SorteOuReves elaboramos um método chamado &quot;acoes&quot; o qual foi criado coma a finalidade de chamar os outros métodos criados a cima.



**       **

**UserStory 6 (Prisão):**

**       ** A classe Prisao foi criada no pacote de posições e ela extende Posicao. Possui como atributos:

        -Scanner leitor;

        -String tipo;

        Foi elaborado um método para checar a liberdade do jogador, o _checandoLiberdade_ procura entender a forma de como o jogador vai ser libertado, ele só pode sair mediante 3 formas:

        -Se ele possuir uma carta de liberdade;

        -Se ele pagar;

        -Se ele tirar dados iguais;

**UserStory 7 (Companhias):**

**       **

**       ** A classe Companhia checa se o jogador está em uma companhia e se ela estiver disponível pergunta se o jogador deseja compra-la. Essa classe também tem o método pagandoAluguelOuMultiplicador que se o jogador cair em uma propriedade de um outro jogador ele terá de pagar aluguel ou um multiplicador porque esse método serve para as companhias e para as propriedades.

**       **
