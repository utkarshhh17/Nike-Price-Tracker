import {useEffect, useState} from "react";
import axios from "axios";
export default function ProductsContent(){

const [productsResponse,setProductsResponse]=useState(null);

    useEffect(() => {
        // dummy data
        /*
        [
            {
                "name": "Nike Air Force 1 Wild",
                "price": 12795,
                "url": "https://www.nike.com/in/t/air-force-1-wild-shoes-FCjQ2C/FB2348-001",
                "imageURL": "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto/1f56268c-4ded-4533-a3ba-5c29bd38210b/air-force-1-wild-shoes-FCjQ2C.png"
            },
            {
                "name": "Nike Air Force 1 Wild",
                "price": 12795,
                "url": "https://www.nike.com/in/t/air-force-1-wild-shoes-FCjQ2C/FB2348-001",
                "imageURL": "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto/1f56268c-4ded-4533-a3ba-5c29bd38210b/air-force-1-wild-shoes-FCjQ2C.png"
            },
            {
                "name": "Nike Air Force 1 Wild",
                "price": 12795,
                "url": "https://www.nike.com/in/t/air-force-1-wild-shoes-FCjQ2C/FB2348-001",
                "imageURL": "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto/1f56268c-4ded-4533-a3ba-5c29bd38210b/air-force-1-wild-shoes-FCjQ2C.png"
            },
            {
                "name": "Nike Air Force 1 Wild",
                "price": 12795,
                "url": "https://www.nike.com/in/t/air-force-1-wild-shoes-FCjQ2C/FB2348-001",
                "imageURL": "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto/1f56268c-4ded-4533-a3ba-5c29bd38210b/air-force-1-wild-shoes-FCjQ2C.png"
            },

        ]
        */

        axios.get("https://localhost:8081/api/products")
        .then((response) => {
            const confirmResponse=response.data;
            if(response.status === 200){
                // JSON Product Object
                console.log(confirmResponse);
                setProductsResponse(confirmResponse);
            }
            else {
                console.error('Request failed');
            }
        })
        .catch((error)=>{
            console.error(error.response.data.error);
        })
       
      }, []);
    
    
    
    
      return (
        <div>
            
        </div>
    )
}