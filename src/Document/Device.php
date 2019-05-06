<?php
namespace App\Document;

use Doctrine\ODM\MongoDB\Mapping\Annotations as MongoDB;

/**
 * @MongoDB\Document
 */

class Device
{
    /**
     * @MongoDB\Id
     */
    protected $id;

    /**
     * @MongoDB\Field(type="string")
     */
    protected $name;
    
    public function setId($id)
    {
        $this->id = $id;
    }
    
    public function setName(String $name)
    {
        $this->name = $name;
    }
    
    public function getName()
    {
        return $this->name;
    }
}
