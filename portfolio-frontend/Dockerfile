# ----------------------------
# Build stage
# ----------------------------
FROM node:24.11.1 AS build

# Crée le répertoire de travail
WORKDIR /app

# Copie package.json et package-lock.json pour installer les dépendances
COPY package*.json ./

# Installe les dépendances
RUN npm install

# Copie tout le code source
COPY . .

# Build Angular en mode production
RUN npm run build -- --output-path=dist --configuration=production

# ----------------------------
# Serve stage
# ----------------------------
FROM nginx:alpine

# Supprime le contenu par défaut de Nginx
RUN rm -rf /usr/share/nginx/html/*

# Copie les fichiers build dans Nginx
COPY --from=build /app/dist/portfolio-frontend /usr/share/nginx/html

# Copie le fichier de configuration Nginx personnalisé (optionnel)
# COPY nginx.conf /etc/nginx/conf.d/default.conf

# Expose le port
EXPOSE 80

# Commande par défaut pour lancer Nginx
CMD ["nginx", "-g", "daemon off;"]
