import {useEffect, useState} from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import { motion } from "framer-motion";
export default function ProductsContent(){

const [productsResponse,setProductsResponse]=useState(null);

const [number,setNumber]=useState(1);

const [selectedData,setSelectedData]=useState({});

const [checkResponse,setCheckResponse]=useState(null);

    useEffect(() => {
        axios.get("http://localhost:8081/api/products",)
        .then((response) => {
            const confirmResponse=response.data;
            if(response.status === 200){
                setProductsResponse(confirmResponse);
                console.log(confirmResponse);
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

      

      const handleCheck=(propURL)=>{
          const name = extractNameFromUrl(propURL);
          const id = extractIdFromUrl(propURL);
          const url = `http://localhost:8081/api/products/t/${name}/${id}`
          // url example = https://www.nike.com/in/t/air-force-1-07-shoes-WrLlWX/CW2288-111
          // get the url of the product selected and
          // extract name = air-force-1-07-shoes-WrLlWX
          // extract id = CW2288-111
          // pass it to the url variable
        axios.get(url)
        .then((response) => {
            const confirmResponse=response.data;
            if(response.status === 200) {
                /* new data is recieved with updated price (same or different) in json in format
                {name: ,
                price: ,
                url: ,
                imageurl: }

                set that new data on that product
                */

                setCheckResponse(confirmResponse);
                console.log(confirmResponse);
                setNumber(3);
            }
            else {
                console.error('Request failed');
            }
        })
        .catch((error)=>{
            console.error(error.response.data.error);
        })

      }

      function extractNameFromUrl(url) {
        const urlParts = url.split('/');
        const nameIndex = urlParts.indexOf('t') + 1;
        return urlParts[nameIndex];
      }
      
      function extractIdFromUrl(url) {
        const urlParts = url.split('/');
        const idIndex = urlParts.indexOf('t') + 2;
        return urlParts[idIndex];
      }


    return (
        <div className="flex flex-wrap mt-20">
            {productsResponse && number === 1 && (
                <div className="flex flex-row flex-wrap justify-center items-center">
                    {productsResponse.map((data, index) => (
                        <div key={index} onClick={() => handleClick(data)} className="m-2">
                            <div className="flex flex-col justify-center items-center h-auto shadow-xl w-60 cursor-pointer hover:scale-110">
                                <img src={data.imageURL} className="" alt={data.name}></img>
                                <div className="mt-2 text-lg">{data.name}</div>
                                <div className="mt-2 text-sm font-roboto">Price: {data.price}</div>
                                <div className="mt-2 text-lg text-red-400 font-jost mb-2">
                                    <Link to={data.url}>Link</Link>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            )}

            {number === 3 && (
                <div className="flex flex-col justify-center items-center relative left-[5vw] h-[45vw] w-[90vw] bg-white">
                    <img src={checkResponse.imageURL} className=" left-[100rem] h-[30vw] w-[30vw]" alt={checkResponse.name}></img>
                    <div className="mt-2 text-3xl">{checkResponse.name}</div>
                    <div className="mt-2 text-xl font-roboto">Price: {checkResponse.price}</div>
                    <motion.button
                        type="submit"
                        whileHover={{ backgroundColor: "#D4A7FB" }}
                        transition={{ duration: 1, ease: "easeOut" }}
                        className="mt-10 mb-7 w-20 h-10 text-white bg-black shadow-lg shadow-gray-400 hover:shadow-lg hover:scale-110"
                        onClick={()=>handleCheck(checkResponse.url)}
                    >
                        Check
                    </motion.button>
                </div>
            )}



            {number === 2 && (
                <div className="flex flex-col justify-center items-center relative left-[5vw] h-[45vw] w-[90vw] bg-white">
                    <img src={selectedData.imageURL} className=" left-[100rem] h-[30vw] w-[30vw]" alt={selectedData.name}></img>
                    <div className="mt-2 text-3xl">{selectedData.name}</div>
                    <div className="mt-2 text-xl font-roboto">Price: {selectedData.price}</div>
                    <motion.button
                        type="submit"
                        whileHover={{ backgroundColor: "#D4A7FB" }}
                        transition={{ duration: 1, ease: "easeOut" }}
                        className="mt-10 mb-7 w-20 h-10 text-white bg-black shadow-lg shadow-gray-400 hover:shadow-lg hover:scale-110"
                        onClick={()=>handleCheck(selectedData.url)}
                    >
                        Check
                    </motion.button>
                </div>
            )}
        </div>
    );
}