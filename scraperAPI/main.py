from fastapi import FastAPI
from URL import URL
from scraper import Scraper

app = FastAPI()
@app.post("/api/products")
async def root(url: URL):
    s = Scraper()
    return s.scrape(url)
