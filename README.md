# Chat Application

A real-time group chat built with Spring Boot WebSockets (STOMP over SockJS) and a plain HTML/JavaScript client.

## Tech Stack

- Java 17, Spring Boot 3.1
- Spring WebSocket with STOMP and an in-memory simple message broker
- SockJS and STOMP.js on the client (loaded from cdnjs)
- Lombok

## Features

- Enter a username and join a single public chat room
- Messages are broadcast to every connected user in real time
- Join and leave notifications when users connect or disconnect
- Colored avatar per user

## Getting Started

### Prerequisites

- JDK 17

No database is required.

### Run

```bash
git clone https://github.com/Hussein-Fouani/Chat_Application.git
cd Chat_Application
./mvnw spring-boot:run
```

Open `http://localhost:8080` in two or more browser tabs, pick a username in each, and start chatting.

## WebSocket API

| Type | Destination | Description |
|------|-------------|-------------|
| Endpoint | `/ws` | SockJS/STOMP connection endpoint |
| Send | `/app/chat.addUser` | Register the username for the session and announce the join |
| Send | `/app/chat.sendMessage` | Send a chat message |
| Subscribe | `/topic/public` | Receive chat messages and join/leave events |

Message payload:

```json
{ "sender": "alice", "content": "Hello!", "type": "CHAT" }
```

`type` is one of `CHAT`, `JOIN`, `LEAVE`.
