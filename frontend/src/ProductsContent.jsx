import {useEffect, useState} from "react";
import axios from "axios";
import { Link } from "react-router-dom";
export default function ProductsContent(){

const [productsResponse,setProductsResponse]=useState(null);


 // dummy data
        
        const dummyData=[
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
        

    useEffect(() => {
       

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
        <div className="flex flex-wrap mt-20">
        {productsResponse && (
            <div>
           {productsResponse.map((data,index)=>(
            <div className="flex flex-col justify-center items-center h-auto ml-10 shadow-xl w-60" key={index}>
                <img src={data.imageURL} className=""></img> 
                <div className="mt-2 text-lg">{data.name}</div>
                <div className="mt-2 text-sm font-roboto">Price:{data.price}</div>
                <div className="mt-2 text-lg text-red-400 font-jost mb-2"><Link to={data.url}>Link</Link></div>

            </div>
           ))}
           </div>
           )
           }
        </div>
    )
}