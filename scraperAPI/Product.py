class Product:
    def __init__(self, name: str, price: int, url: str, image_url: str):
        self.name = name
        self.price = price
        self.url = url
        self.imageurl = image_url

    def __str__(self):
        return f"name: {self.name}, price: {self.price}, url: {self.url}, imageurl: {self.imageurl}"
