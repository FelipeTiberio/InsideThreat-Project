# InsideThreat-Project
Sistema que permite a representação de perfis de usuários a partir de arquivos de log (CSV) , para uma comparação posterior a fim de identificar usuários como comportamento suspeito.



#Objetivos Específicos

O projeto apresenta os seguinte objetivos específicos que deverão ser contemplados pelo seu programa:

1. Leitura de arquivos de log como entrada de dados [ ].
2. Montagem dos perfis de usuários [ ].
3. Visualização dos perfis de usuários [ ].
4. Detecção de anomalias [ ].

##---------------------------------------------------------------
# Classes:

(Para o primeiro nivel da árvore será necessário )
[].Implementar uma classe observations, (irá fica no primeiro nível da TreeProfile)
Ainda não sei bem quais atributos irei precisar.

[x].Implementar uma LogAnalyzer.
(A classe é usada apenas para a leitura dos arquivos de log.)
private List<String[]> entries = new ArrayList<>();
private BufferedReader filebr = null;

[].Implementar uma classe TreeProfile, essa classe irá gerenciar cada um dos nós da árvore.

[].Implementar uma classe FileReader, (Talvez não use essa aqui )

[].Implementar uma classe que ficará na camada de controle criando os perfices de cada usuário (Essa classe também criará o perfil por papel ou se tornará uma classe abstrata capaz de criar perfis).

[].Implementar uma estrutura em árvore n-ária, que obedece o comportamento descrito no arquivo do projeto

[x].Implementar uma classe User, com os atributos iniciais:
employee_name, user_id, email, domain, role.

[x].Implementar uma classe Device, com os atributos iniciais:
id, date, user, pc, activit.

[x].Implementar uma classe Http
id, date, user, pc, url.

[x].Implementar uma classe Logon
id, date, user, pc, activity.

[].Implementar uma classe histograma, ou usar uma api, cada nó da árvore de perfil de usuário terá uma classe dessas.

# Tarefas:

[x]. Tratamento dos dados que estão nos arquivos de log.
[]. Tratar erros de leitura de arquivos.
[]. Tratar qualquer outro tipo de erro identificado.
[]. Colocar os arquivos em pacotes no modelo MVC.
# -------------------------------------------------------------

[]. Salvar o perfil do usuário em um arquivo de log.
[]. Criar um interface gráfica para o projeto.
[]. No programa deve ser permito que a existência de filtros de atividades e usuário

# -------------------------
#REFERENCIAS
https://www.javagists.com/java-tree-data-structure (Implementação inicial da árvore)


