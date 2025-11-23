# ----------------------------
# Build stage
# ----------------------------
FROM node:24.11.1 AS build

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build -- --configuration=production

# ----------------------------
# Serve stage
# ----------------------------
FROM nginx:alpine

RUN rm -rf /usr/share/nginx/html/*

# Copier le bon dossier build
COPY --from=build /app/dist/portfolio-frontend /usr/share/nginx/html

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
