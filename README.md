# ToDo Web Application

A simple full-stack to-do application built with:
- ✅ **Java (Spring Boot)** for backend
- ✅ **MySQL** as the database
- ✅ **HTML/CSS/JS** for frontend
- ✅ **Docker & Docker Compose** to manage services

---

## 📦 Project Structure

```
todo-app/
├── backend/       # Spring Boot REST API
├── frontend/      # Static frontend UI
├── docker-compose.yml
├── README.md
```

---

## 🚀 How to Build & Run the Project

### ✅ Prerequisites
- [Docker](https://www.docker.com/products/docker-desktop) installed
- [Docker Compose](https://docs.docker.com/compose/) installed

### 🧭 Steps

1. **Clone or download this project**

2. **Open terminal inside the project root folder**

3. **Run the following command:**

```bash
docker-compose up --build
```

This will:
- Build and run the Spring Boot backend
- Set up a MySQL database
- Serve the frontend via Nginx

---

## 🌐 Access the App

| Component  | URL                          | Description           |
|------------|------------------------------|-----------------------|
| Frontend   | http://localhost:3000        | User Interface        |
| Backend API| http://localhost:8080/api    | REST endpoints        |
| MySQL DB   | localhost:3306               | MySQL container       |

---

## 🧪 Testing (optional)
If you add JUnit or integration tests to the backend, you can run them inside the `backend` folder like this:
```bash
cd backend
mvn test
```

---

## 🛑 Stop the Application
To stop all running containers:
```bash
docker-compose down
```

---

## 🧹 Clean up Docker Images (Optional)
```bash
docker system prune -a
```

---

## 📌 Notes
- First time startup may take a few seconds while MySQL initializes.
- The application is designed to automatically create tables in the database.
- Make sure no other app uses ports `3000`, `8080`, or `3306`.

---

## ✨ Features
- Add new tasks
- View only top 5 recent incomplete tasks
- Mark tasks as completed
- Responsive and simple UI