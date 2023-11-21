from requests_html import HTMLSession
from Product import Product
from URL import URL
import re


class Scraper:
    def __init__(self):
        self.session = HTMLSession()
        self.res = None
        self.name = None
        self.price = None
        self.url = None
        self.image_url = None

    def scrape(self, url: URL):
        self.res = self.session.get(url.url)
        self.price = self.res.html.find('.product-price.css-11s12ax.is--current-price.css-tpaepq', first=True)
        self.name = self.res.html.find('.headline-2.css-16cqcdq', first=True)
        self.url = url
        self.image_url = self.res.html.find('img.css-viwop1.css-m5dkrx', first=True)


        return Product(self.name.text, self.parse_price(), self.url.url, self.image_url.attrs.get('src'))

    def parse_price(self):
        return int("".join(re.findall("[0-9]", self.price.text))[:-2])


