FROM node:18.7.0-slim AS builder

WORKDIR /code
COPY package.json /code/package.json
COPY package-lock.json /code/package-lock.json

RUN npm i
COPY . /code

CMD ["npm", "run", "dev"]
