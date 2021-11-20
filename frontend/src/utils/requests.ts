/* "??" operador que verifica que se a variável de ambiente não estiver definida
   no ambiente de aplicação em que ela estiver rodando, ele pega o valor que está
   à direita */
export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? "http://localhost:8080"