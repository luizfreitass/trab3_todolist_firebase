# 📝 ToDo List App (Firebase Auth + MVVM)

Este é um aplicativo de gerenciamento de tarefas desenvolvido **nativamente para Android**, utilizando **Kotlin** e **Jetpack Compose**.  
O projeto implementa **autenticação de usuários via Firebase Authentication** e **persistência local com Room Database**, garantindo que cada usuário tenha acesso exclusivo e seguro às suas próprias tarefas.

O aplicativo foi desenvolvido como parte de um **trabalho acadêmico da disciplina de Programação para Dispositivos Móveis**.

---

## 📚 Contexto Acadêmico

Este projeto foi desenvolvido como atividade avaliativa da disciplina de **Programação para Dispositivos Móveis**, contemplando os seguintes requisitos:

- Desenvolvimento nativo para Android  
- Uso da linguagem Kotlin  
- Implementação de persistência local de dados  
- Autenticação de usuários  
- Separação entre lógica de negócio e interface do usuário  
- Aplicação de um padrão arquitetural moderno (MVVM)

---

## 📱 Funcionalidades

### 🔐 Autenticação Segura
- Login com e-mail e senha (Firebase Authentication)
- Cadastro de novos usuários (Sign Up)
- Logout e gerenciamento de sessão
- Proteção de rotas: usuários não autenticados não acessam a lista de tarefas

### ✅ Gerenciamento de Tarefas
- Visualização da lista de tarefas em tempo real
- Adicionar nova tarefa (título e descrição)
- Editar tarefas existentes
- Marcar tarefas como concluídas (checkbox com persistência de estado)
- Excluir tarefas

### 🔒 Privacidade de Dados
- **Isolamento por Usuário**  
  As tarefas são isoladas por usuário. Um usuário jamais verá ou editará as tarefas de outro.

---

## 🚀 Evolução e Diferenciais vs. Versão Anterior

Este projeto representa uma evolução significativa em relação à versão anterior (*Simple To-Do List*), introduzindo maior complexidade arquitetural para suportar múltiplos usuários, segurança e boas práticas de desenvolvimento.

### 1️⃣ Implementação de Autenticação (Firebase)

**Versão anterior:**  
O aplicativo era acessado diretamente, sem identificação do usuário.

**Versão atual:**  
Integração completa com o Firebase Authentication, com telas de Login e Cadastro, além de controle de sessão e proteção de acesso à lista de tarefas.

---

### 2️⃣ Isolamento de Dados (User-Centric Data)

**Versão anterior:**  
O banco de dados local (Room) era compartilhado globalmente no dispositivo.

**Versão atual:**  
Implementação de *multi-tenancy lógico* (suporte a multiplos usuarios):
- A entidade `TodoEntity` recebeu o campo `userId`
- Todas as consultas do DAO filtram os dados pelo usuário logado (`WHERE userId = :id`)
- O repositório injeta automaticamente o ID do usuário autenticado nas operações

---

### 3️⃣ Arquitetura MVVM Reativa
- Adoção do padrão MVVM (Model-View-ViewModel)
- Gerenciamento de estado reativo utilizando **StateFlow**
- A interface reage automaticamente às mudanças emitidas pelos ViewModels (`AuthViewModel`, `ListViewModel`)
- Garantia do conceito de **Single Source of Truth**, mantendo UI e dados sempre sincronizados

---

### 4️⃣ Navegação Condicional
- O grafo de navegação (`NavHost`) define dinamicamente o `startDestination`
- O destino inicial é decidido com base no estado da sessão do usuário
- Redirecionamento automático para Login ou Lista de Tarefas

---

## 🛠️ Tecnologias & Bibliotecas

- **Linguagem:** Kotlin  
- **UI Toolkit:** Jetpack Compose (Material Design 3)  
- **Arquitetura:** MVVM + Repository Pattern  
- **Banco de Dados Local:** Room Database  
- **Autenticação:** Firebase Authentication  
- **Assincronismo:** Coroutines & Flow  
- **Navegação:** Navigation Compose  

---

## 🏗️ Decisões de Arquitetura

### 📐 Padrão Arquitetural
O projeto segue estritamente o padrão **MVVM**, promovendo:
- Separação clara de responsabilidades
- Melhor testabilidade
- Manutenção facilitada

---

### 📂 Organização do Código (Package by Feature)

Foi adotada a estratégia de **Package by Feature** na camada de UI, organizando o código por funcionalidade:

```text
ui/
 └── feature/
	 ├── auth
	 ├── list
	 └── addedit
```

**Justificativa Técnica:**
- **Alta coesão:** Telas, ViewModels e eventos relacionados ficam no mesmo pacote
- **Escalabilidade:** Facilita manutenção e futura modularização
- **Legibilidade:** Evita pacotes genéricos e excessivamente grandes

---

### 💾 Camada de Dados

- **Room Database:**  
  Configurado com `.fallbackToDestructiveMigration()` durante a fase de desenvolvimento acadêmico, permitindo a evolução rápida do schema (como a adição do campo `userId`) sem causar falhas na execução.  
  Em um ambiente de produção, seria adotada uma estratégia de migração versionada.

- **Repository Pattern:**  
  O `TodoRepositoryImpl` atua como **única fonte da verdade**, centralizando o acesso aos dados e garantindo que todas as operações estejam associadas ao usuário autenticado.

---

## 🎨 Interface do Usuário (UI/UX)

- **Fluxo de Autenticação:**  
  Feedback visual claro com uso de **Snackbars** para mensagens de erro (e-mail inválido, senha incorreta, etc.).

- **Lista de Tarefas:**  
  Design limpo com **Cards**, oferecendo ações rápidas para concluir ou excluir tarefas.

- **Consistência:**  
  Toda a interface foi padronizada para o idioma **Português**, garantindo uma experiência fluida ao usuário.

---

## 🚀 Como Executar o Projeto

### 📋 Pré-requisitos
- Android Studio (versão mais recente recomendada)
- Conta no Google Firebase

### 🔥 Configuração do Firebase

1. Crie um projeto no Firebase Console  
2. Adicione um aplicativo Android com o pacote: com.example.todolist (ou o pacote definido no build.gradle)
3. Baixe o arquivo `google-services.json`  
4. Coloque o arquivo na pasta `app/` do projeto  
5. Ative o método de autenticação **Email/Password** no Firebase  

> ⚠️ **Nota de Segurança (Contexto Acadêmico):**  
> O arquivo `google-services.json` foi mantido no repositório propositalmente para fins acadêmicos, facilitando a correção e execução do projeto pelo avaliador.  
> Em um ambiente de produção real, esse arquivo seria ignorado pelo Git e injetado via CI/CD.

---

### ▶️ Execução

1. Clone este repositório  
2. Abra o projeto no Android Studio  
3. Aguarde a sincronização do Gradle  
4. Execute em um emulador Android (API 30+ recomendada)

---

## ✒️ Autores

Luiz Alexandre Anchieta Freitas 
Matrícula: 12211GIN008  

Enzo Santos Tavares
Matrícula: 12321BSI288

