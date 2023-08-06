FROM node:18.7.0-slim AS test

WORKDIR /code
COPY package.json /code/package.json
COPY package-lock.json /code/package-lock.json

RUN npm ci
COPY . /code

ENV CI=true
ENV VITE_PORT=3000

CMD ["npm", "run", "dev"]

FROM test AS build-prod

RUN ["npm", "run", "build"]

FROM nginx:1.25.1-alpine AS prod

COPY --from=build-prod /code/dist /usr/share/nginx/html

COPY nginx.conf /etc/nginx/conf.d/default.conf
