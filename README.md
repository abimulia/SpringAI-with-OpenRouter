# OpenRouter + Spring AI Starter  

1) Set API key:
- PowerShell: setx OPENROUTER_API_KEY "sk-or-v1-..." (lalu buka terminal baru)  

2) Edit src/main/resources/application.yml → set model yang diinginkan.  
3) Jalankan: mvn spring-boot:run  
4) Tes: http://localhost:8080/api/ai/ask?q=Halo  
