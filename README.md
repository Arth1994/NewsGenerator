# News API Project

## Description
This project is a Spring Boot application that provides RESTful APIs to fetch news articles from an external news service. It includes functionalities to fetch articles based on search queries, find articles by their titles, and filter articles by source names. The project utilizes caching to improve performance and reduce external API calls.

## Setup
1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Build and run the project using Maven or Gradle.

## Usage

### Fetch News Articles
- **Endpoint**: `/api/news/fetch`
- **Method**: `GET`
- **Parameters**:
  - `q`: Search query (mandatory)
  - `lang`: Language filter (optional)
  - `country`: Country filter (optional)
  - `max`: Maximum number of results (optional, default is 10)
  - `in`: Attributes to search in (optional)
  - `nullable`: Nullable attributes (optional)
  - `from`: Filter articles published after a date (optional)
  - `to`: Filter articles published before a date (optional)
  - `sortby`: Sorting parameter (optional, default is "publishedAt")
- **Sample Request**: `http://localhost:8080/api/news/fetch?q=example&max=10&apikey=[YOUR_API_KEY]`

### Find Article by Title
- **Endpoint**: `/api/news/find-by-title`
- **Method**: `GET`
- **Parameters**:
  - `title`: Title of the news article to find (mandatory)
- **Sample Request**: `http://localhost:8080/api/news/find-by-title?title=%22Your%20work%20questions%20answered:%20I%20was%20appointed%20to%20a%20new%20role%20and%20sent%20back%20to%20my%20old%20one%20within%20days%22&apikey=[YOUR_API_KEY]`

### Filter Articles by Source Name
- **Endpoint**: `/api/news/by-source`
- **Method**: `GET`
- **Parameters**:
  - `sourceName`: Name of the news source (mandatory)
- **Sample Request**: `http://localhost:8080/api/news/by-source?sourceName=The%20Irish%20Times&apikey=[YOUR_API_KEY]`

## Sample Test APIs

### Fetch Example Articles
- **Sample Request**: `http://localhost:8080/api/news/fetch?q=example&max=10&apikey=[YOUR_API_KEY]`

### Find Article by Title
- **Sample Request**: `http://localhost:8080/api/news/find-by-title?title=%22Your%20work%20questions%20answered:%20I%20was%20appointed%20to%20a%20new%20role%20and%20sent%20back%20to%20my%20old%20one%20within%20days%22&apikey=[YOUR_API_KEY]`

### Filter Articles by Source Name
- **Sample Request**: `http://localhost:8080/api/news/by-source?sourceName=The%20Irish%20Times&apikey=[YOUR_API_KEY]`

*Note: Replace `[YOUR_API_KEY]` with your actual API key.*
