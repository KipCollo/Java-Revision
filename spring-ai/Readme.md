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

- `AI Models`:-AI models are algorithms designed to process and generate information, often mimicking human cognitive functions. By learning patterns and insights from large datasets, these models can make predictions, text, images, or other outputs, enhancing various applications across industries.

There are many different types of AI models, each suited for a specific use case. While ChatGPT and its generative AI capabilities have captivated users through text input and output, many models and companies offer diverse inputs and outputs.

Spring AI currently supports models that process input and output as language, image, and audio.
What sets models like GPT apart is their pre-trained nature, as indicated by the "P" in GPT—Chat Generative Pre-trained Transformer. This pre-training feature transforms AI into a general developer tool that does not require an extensive machine learning or model training background.

- `Prompts`:- Prompts serve as the foundation for the language-based inputs that guide an AI model to produce specific outputs.
- `Embeddings`:- Embeddings are numerical representations of text, images, or videos that capture relationships between inputs.Embeddings work by converting text, image, and video into arrays of floating point numbers, called vectors. These vectors are designed to capture the meaning of the text, images, and videos. The length of the embedding array is called the vector’s dimensionality.
By calculating the numerical distance between the vector representations of two pieces of text, an application can determine the similarity between the objects used to generate the embedding vectors.
Embeddings are particularly relevant in practical applications like the Retrieval Augmented Generation (RAG) pattern. They enable the representation of data as points in a semantic space, which is akin to the 2-D space of Euclidean geometry, but in higher dimensions. This means just like how points on a plane in Euclidean geometry can be close or far based on their coordinates, in a semantic space, the proximity of points reflects the similarity in meaning. Sentences about similar topics are positioned closer in this multi-dimensional space, much like points lying close to each other on a graph. This proximity aids in tasks like text classification, semantic search, and even product recommendations, as it allows the AI to discern and group related concepts based on their "location" in this expanded semantic landscape.
 -`Tokens`:- Tokens serve as the building blocks of how an AI model works. On input, models convert words to tokens. On output, they convert tokens back to words.
In the context of hosted AI models, your charges are determined by the number of tokens used. Both input and output contribute to the overall token count.
Also, models are subject to token limits, which restrict the amount of text processed in a single API call. This threshold is often referred to as the "context window". The model does not process any text that exceeds this limit.

**Structured Output**:- The output of AI models traditionally arrives as a java.lang.String, even if you ask for the reply to be in JSON. It may be a correct JSON, but it is not a JSON data structure. It is just a string. Also, asking “for JSON” as part of the prompt is not 100% accurate.

This intricacy has led to the emergence of a specialized field involving the creation of prompts to yield the intended output, followed by converting the resulting simple string into a usable data structure for application integration.

*Bringing Your Data & APIs to the AI Model*:-

- Three techniques exist for customizing the AI model to incorporate your data:
  1. Fine Tuning: This traditional machine learning technique involves tailoring the model and changing its internal weighting. However, it is a challenging process for machine learning experts and extremely resource-intensive for models like GPT due to their size. Additionally, some models might not offer this option.
  2. Prompt Stuffing: A more practical alternative involves embedding your data within the prompt provided to the model. Given a model’s token limits, techniques are required to present relevant data within the model’s context window. This approach is colloquially referred to as “stuffing the prompt.” The Spring AI library helps you implement solutions based on the “stuffing the prompt” technique otherwise known as Retrieval Augmented Generation (RAG).
  3. Tool Calling: This technique allows registering tools (user-defined services) that connect the large language models to the APIs of external systems. Spring AI greatly simplifies code you need to write to support tool calling.

Retrieval Augmented Generation

A technique termed Retrieval Augmented Generation (RAG) has emerged to address the challenge of incorporating relevant data into prompts for accurate AI model responses.

## Chat Client API

The ChatClient offers a fluent API for communicating with an AI Model. It supports both a synchronous and streaming programming model.

The fluent API has methods for building up the constituent parts of a Prompt that is passed to the AI model as input. The Prompt contains the instructional text to guide the AI model’s output and behavior. From the API point of view, prompts consist of a collection of messages.

The AI model processes two main types of messages: user messages, which are direct inputs from the user, and system messages, which are generated by the system to guide the conversation.

These messages often contain placeholders that are substituted at runtime based on user input to customize the response of the AI model to the user input.

There are also Prompt options that can be specified, such as the name of the AI Model to use and the temperature setting that controls the randomness or creativity of the generated output.

`Creating a ChatClient`:- The ChatClient is created using a ChatClient.Builder object. You can obtain an auto-configured ChatClient.Builder instance for any ChatModel Spring Boot auto-configuration or create one programmatically.

