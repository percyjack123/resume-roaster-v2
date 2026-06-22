
# 🔥 Resume Roaster — AI-Powered Resume Analyzer

An AI-driven full-stack web application that analyzes resumes and generates brutally honest feedback with a score, helping users improve their resumes for better job prospects.

---

## 🚀 Overview

Resume Roaster is a production-style full-stack application built using **Spring Boot** and **React**, integrated with **Google Gemini AI** to provide intelligent resume evaluation.

Users can upload their resumes in PDF format, and the system extracts content, analyzes it using AI, and returns structured feedback along with a rating and actionable improvement suggestions.

---

## ❓ Problem Statement

Many students and job seekers submit resumes without understanding how recruiters, ATS systems, and hiring managers evaluate them. Generic feedback often fails to identify critical weaknesses in structure, impact, technical skills presentation, and project descriptions.

Resume Roaster addresses this challenge by leveraging AI to analyze resume content, identify weaknesses, provide actionable recommendations, and generate an overall resume score.

---

## 🧠 Key Features

- 📄 Upload resumes in PDF format
- 🤖 AI-powered analysis using Google Gemini API
- 📊 Generates structured feedback with scoring
- 🔥 Roast-style feedback for engaging UX
- 💡 Actionable improvement recommendations
- ⚡ Fast and responsive user interface
- 🛠 Clean REST API architecture
- 📑 Automatic PDF text extraction

---

## 🏗 System Architecture

```text
User Uploads Resume (PDF)
            │
            ▼
React Frontend (Vite)
            │
            ▼
Spring Boot REST API
            │
            ▼
PDF Text Extraction (PDFBox)
            │
            ▼
Google Gemini API
            │
            ▼
Resume Analysis & Scoring
            │
            ▼
Structured Feedback Response
```

---

## 🏗 Tech Stack

### Backend

- Java
- Spring Boot
- REST APIs
- Apache PDFBox

### Frontend

- React
- Vite
- Tailwind CSS

### AI Integration

- Google Gemini API

### Deployment

- Vercel (Frontend)
- Railway (Backend)

---

## ⚙️ How It Works

1. User uploads a resume PDF.
2. Backend extracts text using Apache PDFBox.
3. Resume content is processed and sent to Gemini AI.
4. AI evaluates formatting, skills, projects, and impact.
5. A score and detailed feedback are generated.
6. Results are displayed through the React frontend.

---

## 🎯 Key Learning Outcomes

- Built a production-style full-stack application
- Integrated external AI services using REST APIs
- Implemented PDF processing and text extraction
- Designed prompt engineering workflows
- Developed scalable Spring Boot backend services
- Deployed frontend and backend independently

---

## 🔗 Live Demo

https://resume-roaster-v2.vercel.app/

---

## 📦 Installation

### Backend

```bash
cd backend
mvn spring-boot:run
```

### Frontend

```bash
cd frontend
npm install
npm run dev
```

---

## 🚀 Future Enhancements

- ATS compatibility analysis
- Resume comparison mode
- Industry-specific recommendations
- Multi-page resume support
- Resume version tracking
- Interview readiness insights

---

## 📄 License

MIT License
````
