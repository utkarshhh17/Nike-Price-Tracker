import {useEffect, useState} from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import { motion } from "framer-motion";
export default function ProductsContent(){

const [productsResponse,setProductsResponse]=useState(null);

const [number,setNumber]=useState(1);

const [selectedData,setSelectedData]=useState({});

const [checkResponse,setCheckResponse]=useState(null);


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
       

        axios.get("http://localhost:8081/api/products",)
        .then((response) => {
            const confirmResponse=response.data;
            if(response.status === 200){
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
    

      const handleClick = (value) => {
        setSelectedData(value);
        setNumber(2);
      };

      const handleCheck=()=>{
        axios.put("",)
        .then((response) => {
            const confirmResponse=response.data;
            if(response.status === 200){
                setCheckResponse(confirmResponse);
            }
            else {
                console.error('Request failed');
            }
        })
        .catch((error)=>{
            console.error(error.response.data.error);
        })

      }
    
    
    
      return (
        <div className="flex flex-wrap mt-20">
        {productsResponse && number===1 && (
            <div>
           {productsResponse.map((data,index)=>(
            <div key={index} onClick={() => handleClick(data)}>
            
            <div className="flex flex-col justify-center items-center h-auto ml-10 shadow-xl w-60 cursor-pointer hover:scale-110" >
                <img src={data.imageURL} className=""></img> 
                <div className="mt-2 text-lg">{data.name}</div>
                <div className="mt-2 text-sm font-roboto">Price:{data.price}</div>
                <div className="mt-2 text-lg text-red-400 font-jost mb-2"><Link to={data.url}>Link</Link></div>

            </div>

            </div>
           ))}
           </div>
           )
           }
   

           {number ===2 && (
            <div className="flex flex-col justify-center items-center relative left-[25vw] h-[30vw] w-[50vw] bg-slate-400 ">
            <img src={selectedData.imageURL} className="h-[15vw] w-[15vw]"></img> 
            <div className="mt-2 text-lg">{selectedData.name}</div>
            <div className="mt-2 text-sm font-roboto">Price:{selectedData.price}</div>
            <motion.button type="submit" whileHover={{ backgroundColor: "#D4A7FB" }} transition={{duration:1 ,ease:"easeOut"}}  className="mt-10 mb-7 w-20 h-10
                 text-white bg-black shadow-lg shadow-gray-400 hover:shadow-lg hover:scale-110">
                    Check
            </motion.button>
            </div>
           )}
           
        </div>
    )
}