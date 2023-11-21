class Product:
    def __init__(self, name: str, price: int, url: str, image_url: str):
        self.name = name
        self.price = price
        self.url = url
        self.image_url = image_url

    def __str__(self):
        return f"Name: {self.name}, Price: {self.price}, URL: {self.url}, ImageURL: {self.image_url}"
