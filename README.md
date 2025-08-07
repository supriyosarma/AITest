# 🤖 AI-Powered Java App with Spring Boot & Spring AI (OpenAI Integration)

This project demonstrates how to integrate **OpenAI's powerful language models** with a **Java Spring Boot** application using **Spring AI**. It exposes clean, RESTful APIs that allow users to send prompts and receive intelligent responses from OpenAI.

The application supports contextual AI conversations by retaining chat history during a user's session using HttpSession.

---

## ✨ Features

- ✅ RESTful API built with **Spring Web**
- 🤖 Seamless AI integration using **Spring AI + OpenAI**
- 🔧 Clean Maven project structure for easy build & management
- 🧪 Ready for extension (chatbots, summarizers, resume tools, etc.)

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring AI**
- **Maven**
- **OpenAI API**

---

## 📦 Prerequisites

- Java **17 or higher**
- Maven **3.8.1 or higher**
- OpenAI API Key (`OPENAI_API_KEY` used as a property)

---

## 🚀 Getting Started

### Clone the Repository

git clone https://github.com/supriyosarma/AITest.git

### Configure API Key

Generate the API key from OpenAI website and put it in the properties file placeholder.

### Build the Project

mvn clean install

### Run the Application

mvn spring-boot:run

📍 The application will start on:
http://localhost:8080

### Sample Endpoint

POST /api/chat
--------------

{
  "prompt": "Explain dependency injection in Spring"
}

Returns
-------

{
  "response": "Dependency Injection (DI) in Spring is a design pattern..."
}
