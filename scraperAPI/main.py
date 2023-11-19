from fastapi import FastAPI
from URL import URL
from scraper import Scraper
from fastapi.middleware.cors import CORSMiddleware


app = FastAPI()
origins = ["*"]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)
@app.post("/api/products")
async def root(url: URL):
    s = Scraper()
    return s.scrape(url)
