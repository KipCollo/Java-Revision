# SPRING AI

The Spring AI project aims to streamline the development of applications that incorporate artificial intelligence functionality without unnecessary complexity.

The project draws inspiration from notable Python projects, such as LangChain and LlamaIndex, but Spring AI is not a direct port of those projects. The project was founded with the belief that the next wave of Generative AI applications will not be only for Python developers but will be ubiquitous across many programming languages.

Spring AI addresses the fundamental challenge of AI integration: Connecting your enterprise Data and APIs with AI Models.
Spring AI provides abstractions that serve as the foundation for developing AI applications. These abstractions have multiple implementations, enabling easy component swapping with minimal code changes.

Spring AI provides the following features:

1. Portable API support across AI providers for Chat, text-to-image, and Embedding models. Both synchronous and streaming API options are supported. Access to model-specific features is also available.
2. Support for all major AI Model providers such as Anthropic, OpenAI, Microsoft, Amazon, Google, and Ollama. Supported model types include:
   - Chat Completion
   - Embedding
   - Text to Image
   - Audio Transcription
   - Text to Speech
   - Moderation
3. Structured Outputs - Mapping of AI Model output to POJOs.
4. Support for all major Vector Database providers such as Apache Cassandra, Azure Cosmos DB, Azure Vector Search, Chroma, Elasticsearch, GemFire, MariaDB, Milvus, MongoDB Atlas, Neo4j, OpenSearch, Oracle, PostgreSQL/PGVector, PineCone, Qdrant, Redis, SAP Hana, Typesense and Weaviate.
5. Portable API across Vector Store providers, including a novel SQL-like metadata filter API.
6. Tools/Function Calling - Permits the model to request the execution of client-side tools and functions, thereby accessing necessary real-time information as required and taking action.
7. Observability - Provides insights into AI-related operations.
8. Document ingestion ETL framework for Data Engineering.
9. AI Model Evaluation - Utilities to help evaluate generated content and protect against hallucinated response.
10. Spring Boot Auto Configuration and Starters for AI Models and Vector Stores.
11. ChatClient API - Fluent API for communicating with AI Chat Models, idiomatically similar to the WebClient and RestClient APIs.
12. Advisors API - Encapsulates recurring Generative AI patterns, transforms data sent to and from Language Models (LLMs), and provides portability across various models and use cases.
13. Support for Chat Conversation Memory and Retrieval Augmented Generation (RAG).

This feature set lets you implement common use cases, such as “Q&A over your documentation” or “Chat with your documentation.”
