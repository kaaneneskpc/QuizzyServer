# 🧠 Quizzy - Quiz API

[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.10-blue.svg)](https://kotlinlang.org/)
[![Ktor](https://img.shields.io/badge/Ktor-3.2.3-green.svg)](https://ktor.io/)
[![MongoDB](https://img.shields.io/badge/MongoDB-4.10.2-green.svg)](https://www.mongodb.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

**Quizzy** is a modern and scalable quiz API. Built with Kotlin and Ktor framework, supported by MongoDB database, and designed with clean architecture principles as a RESTful API service.

## ✨ Features

### 🎯 Quiz Management
- **Quiz Topics**: Create and manage quiz topics in different categories
- **Quiz Questions**: Multiple choice questions, correct/incorrect answers and explanations
- **Random Questions**: Get random questions from specific topics
- **Bulk Question Upload**: Add multiple questions at once

### 📊 Reporting System
- **Issue Reports**: Users can report problems
- **Report Management**: View and delete reports for admin panel

### 🏗️ Technical Features
- **Clean Architecture**: Domain, Data, Presentation layers
- **Dependency Injection**: Modular structure with Koin
- **RESTful API**: Standard HTTP methods and status codes
- **JSON Serialization**: Type-safe with Kotlinx Serialization
- **MongoDB**: NoSQL database support
- **Validation**: Incoming data validation
- **Error Handling**: Comprehensive error management

## 🚀 Technology Stack

| Technology | Version | Description |
|------------|---------|-------------|
| **Kotlin** | 2.1.10 | Programming language |
| **Ktor** | 3.2.3 | Web framework |
| **MongoDB** | 4.10.2 | NoSQL database |
| **Koin** | 3.5.6 | Dependency injection |
| **Gradle** | - | Build tool |
| **Logback** | 1.4.14 | Logging framework |

## 📁 Project Structure

```
src/main/kotlin/
├── Application.kt                 # Main application file
├── data/                         # Data layer
│   ├── database/
│   │   ├── DatabaseFactory.kt    # MongoDB connection management
│   │   └── entity/               # Database entities
│   ├── mapper/                   # Domain-Entity converters
│   └── repository/               # Repository implementations
├── domain/                       # Domain layer
│   ├── model/                    # Domain models
│   ├── repository/               # Repository interfaces
│   └── util/                     # Domain utilities
├── di/                          # Dependency Injection
│   └── KoinModule.kt            # Koin configuration
└── presentation/                 # Presentation layer
    ├── config/                   # Ktor configurations
    ├── routes/                   # API routes
    ├── util/                     # Presentation utilities
    └── validator/                # Data validation
```

## 🛠️ Installation

### Requirements
- Java 11 or higher
- MongoDB (local or cloud)
- Gradle 7.0+

### 1. Clone the Project
```bash
git clone https://github.com/your-username/quizzy.git
cd quizzy
```

### 2. Install Dependencies
```bash
./gradlew build
```

### 3. Configure MongoDB Connection
```bash
export MONGO_URL="mongodb://localhost:27017"
# or for MongoDB Atlas:
export MONGO_URL="mongodb+srv://username:password@cluster.mongodb.net"
```

### 4. Start the Application
```bash
./gradlew run
```

The application will run at `http://localhost:8080`.

## 📚 API Documentation

### Base URL
```
http://localhost:8080
```

### 🎯 Quiz Topics

#### Get all topics
```http
GET /quiz/topics
```

#### Get specific topic
```http
GET /quiz/topics/{topicId}
```

#### Add new topic
```http
POST /quiz/topics
Content-Type: application/json

{
  "name": "Kotlin Programming",
  "imageUrl": "/images/kotlin.png",
  "code": 1
}
```

#### Delete topic
```http
DELETE /quiz/topics/{topicId}
```

### ❓ Quiz Questions

#### Get all questions for specific topic
```http
GET /quiz/questions?topicCode=1
```

#### Get random questions
```http
GET /quiz/questions/random?topicCode=1&limit=5
```

#### Get specific question
```http
GET /quiz/questions/{questionId}
```

#### Add new question
```http
POST /quiz/questions
Content-Type: application/json

{
  "question": "On which platforms does Kotlin run?",
  "correctAnswer": "All platforms",
  "incorrectAnswers": ["Only Android", "Only JVM", "Only Web"],
  "explanation": "Kotlin is a multiplatform language",
  "topicCode": 1
}
```

#### Add questions in bulk
```http
POST /quiz/questions/bulk
Content-Type: application/json

[
  {
    "question": "Question 1",
    "correctAnswer": "Correct answer",
    "incorrectAnswers": ["Wrong 1", "Wrong 2", "Wrong 3"],
    "explanation": "Explanation",
    "topicCode": 1
  }
]
```

#### Delete question
```http
DELETE /quiz/questions/{questionId}
```

### 📋 Issue Reports

#### Get all reports
```http
GET /report/issues
```

#### Add new report
```http
POST /report/issues
Content-Type: application/json

{
  "questionId": "question123",
  "issueType": "WRONG_ANSWER",
  "additionalComment": "This question's answer is wrong",
  "userEmail": "user@example.com",
  "timestamp": "2024-01-15T10:30:00Z"
}
```

#### Delete report
```http
DELETE /report/issues/{reportId}
```

## 🔧 Development

### Running in Development Mode
```bash
./gradlew run
```

### Running Tests
```bash
./gradlew test
```

### Creating JAR File
```bash
./gradlew shadowJar
```

## 🌐 Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `MONGO_URL` | MongoDB connection URL | Required |
| `PORT` | Application port | 8080 |

## 📊 Data Models

### QuizTopic
```kotlin
data class QuizTopic(
    val id: String? = null,
    val name: String,
    val imageUrl: String,
    val code: Int
)
```

### QuizQuestion
```kotlin
data class QuizQuestion(
    val id: String? = null,
    val question: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>,
    val explanation: String,
    val topicCode: Int
)
```

### IssueReport
```kotlin
data class IssueReport(
    val id: String? = null,
    val questionId: String,
    val issueType: String,
    val additionalComment: String?,
    val userEmail: String?,
    val timestamp: String
)
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## 👨‍💻 Developer

**Kaan Enes Kıpçı**
- GitHub: [@kaaneneskpc](https://github.com/kaaneneskpc)

## 🆘 Support

If you encounter any issues or have suggestions, please reach out to us via the [Issues](https://github.com/your-username/quizzy/issues) page.

---

⭐ If you liked this project, don't forget to give it a star!