# 📝 Todo App — Full Stack (Java + MySQL + Docker)

A simple, modern full-stack Todo Application built with:

- 🔧 Java 17 & Spring Boot 3
- 🛢 MySQL (Dockerized)
- 🌐 HTML/CSS/JS (Vanilla)
- 🐳 Docker & Docker Compose

---

## 🚀 Features

- Add and manage tasks
- Top 5 recent incomplete tasks listed
- Mark tasks as done
- REST API built with Spring Boot
- MySQL-backed persistence layer
- Fully containerized (backend + frontend + db)

---

## 📦 Project Structure

```bash
todo-app/
├── backend/       # Spring Boot API
├── frontend/      # HTML/CSS/JS UI
├── db/            # SQL init (optional)
├── docker-compose.yml
├── README.md
└── .gitignore
```

---

## 🛠 Setup & Run

### 🔁 Prerequisites
- [Docker](https://docs.docker.com/get-docker/)
- Optional: [Java 17](https://adoptium.net/) and [Maven](https://maven.apache.org/) (for local dev)

### ▶️ Run with Docker Compose

```bash
docker-compose up --build
```

Then access:
- Frontend: [http://localhost:3000](http://localhost:3000)
- API: [http://localhost:8080/api/tasks](http://localhost:8080/api/tasks)

---

## ✅ API Endpoints

| Method | Endpoint                 | Description              |
|--------|--------------------------|--------------------------|
| GET    | `/api/tasks`             | Get top 5 recent tasks   |
| POST   | `/api/tasks`             | Create a new task        |
| PUT    | `/api/tasks/{id}/complete` | Mark task as completed |

---

## 🧪 Testing

### Run Unit & Integration Tests

If Maven is installed:
```bash
cd backend
mvn test
```

Or run tests via Docker:
```bash
docker run --rm -v "$PWD/backend":/app -w /app maven:3.9.6-eclipse-temurin-17 mvn test
```

---

## 📚 Tech Stack

- Java 17, Spring Boot
- MySQL 8
- HTML/CSS/JS
- Docker + Docker Compose
- JUnit 5, Mockito

---

## 🤝 Contributing

Pull requests welcome. For major changes, please open an issue first.

---

## 🙋‍♂️ Author

Developed by [Thamira Weerakoon] — [LinkedIn](https://www.linkedin.com/in/thamira-weerakoon-bb43522a4/) | [GitHub](https://github.com/ThamiraWeerakoon)
